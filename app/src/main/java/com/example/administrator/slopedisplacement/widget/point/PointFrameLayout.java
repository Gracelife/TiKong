package com.example.administrator.slopedisplacement.widget.point;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.AnimationDrawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.target.Target;
import com.example.administrator.slopedisplacement.R;

import java.util.List;

/**
 *
 */

public class PointFrameLayout extends FrameLayout {
    private Context mContext;
    private ImageView mIvBg;
    private FrameLayout mFlPoint;
    private String mBgImgUrl;

    private PointDataBean imgPointBean;
    private int mPointSize = 1;

    public PointFrameLayout(@NonNull Context context) {
        this(context, null);
    }

    public PointFrameLayout(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public PointFrameLayout(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mContext = context;
        this.initView();
    }

    private void initView() {
        mPointSize = dip2px(mContext, 25);//点的大小
        View imgPointLayout = inflate(mContext, R.layout.widget_point_img, this);
        mIvBg = (ImageView) imgPointLayout.findViewById(R.id.IvWidgetPointAndImg);
        mFlPoint = (FrameLayout) imgPointLayout.findViewById(R.id.FlWidgetPointAndImg);
    }

    /**
     * 设置背景图
     *
     * @param bgImgUrl 图片网络地址
     */
    public void setBgImgUrl(String bgImgUrl) {
        this.mBgImgUrl = bgImgUrl;
    }

    /**
     * 设置数据
     *
     * @param imgPointBean
     */
    public void setPointsInfo(PointDataBean imgPointBean) {
        this.imgPointBean = imgPointBean;
    }

    /**
     * 刷新（添加完数据再调用）
     */
    public void refresh() {
        ViewGroup.LayoutParams lp = mIvBg.getLayoutParams();
        mIvBg.setLayoutParams(lp);
        Glide.with(mContext)
                .load(mBgImgUrl)
                .asBitmap()
                .into(new SimpleTarget<Bitmap>(Target.SIZE_ORIGINAL, Target.SIZE_ORIGINAL) {
                    @Override
                    public void onResourceReady(Bitmap resource, GlideAnimation glideAnimation) {
                        //获取图片原始宽高
                        int originalWidth = resource.getWidth();//原始图的宽度
                        int originalHeight = resource.getHeight();//原始图的高度

                        //获取图片显示（即拉伸后的图）后的宽高
                        int currentWidth;//拉伸后图的宽度
                        int currentHeight;//拉伸后图的高度
                        if (originalWidth / originalHeight - mFlPoint.getWidth() / mFlPoint.getHeight() > 0) {//图片的宽大于容器的宽
                            currentWidth = mFlPoint.getWidth();
                            currentHeight = mFlPoint.getWidth() * originalHeight / originalWidth;
                        } else {
                            currentWidth = mFlPoint.getHeight() * originalWidth / originalHeight;
                            currentHeight = mFlPoint.getHeight();
                        }
                        refreshData(originalWidth, originalHeight, currentWidth, currentHeight);
                        addPoint();
                        Bitmap bitmap = createWaterMaskBitmap(resource);
                        mIvBg.setImageBitmap(bitmap);

                    }
                });
    }

    /**
     * 根据图片的原始高和宽、拉伸后的高、宽更新imgPointBean里点的数据
     *
     * @param originalWidth  原始图的宽度
     * @param originalHeight 原始图的高度
     * @param currentWidth   拉伸后图的宽度
     * @param currentHeight  拉伸后图的高度
     */
    private void refreshData(int originalWidth, int originalHeight, int currentWidth, int currentHeight) {
        List<PointBean> pointLists = imgPointBean.getPointBeanList();
        for (PointBean pointBean : pointLists) {
            //初始化
            // 点在拉伸后的图里的位置
            pointBean.setOriginalMarginTop((int) (originalHeight * pointBean.getYScale()));
            pointBean.setOriginalMarginLeft((int) (originalWidth * pointBean.getXScale()));

            // 点在屏幕里实际的位置
            pointBean.setMarginLeft((getMargin(mFlPoint.getWidth(), currentWidth, mPointSize, pointBean.getXScale())));
            pointBean.setMarginTop(getMargin(mFlPoint.getHeight(), currentHeight, mPointSize, pointBean.getYScale()));
        }
    }

    /**
     * 添加点
     */
    private void addPoint() {
        mFlPoint.removeAllViews();
        List<PointBean> pointLists = imgPointBean.getPointBeanList();
        ImageView imageView;
        for (PointBean pointBean : pointLists) {
            //添加点
            imageView = new ImageView(mContext);
//            imageView.setImageResource(R.drawable.prod_point_img);
            imageView.setTag(pointBean.getPointId());
            if (pointBean.isPlayAnimation()) {
                ((AnimationDrawable) imageView.getDrawable()).start();
            } else {
                ((AnimationDrawable) imageView.getDrawable()).stop();
            }
            LayoutParams layoutParams = new LayoutParams(mPointSize, mPointSize);
            layoutParams.leftMargin = pointBean.getMarginLeft();
            layoutParams.topMargin = pointBean.getMarginTop();
            imageView.setLayoutParams(layoutParams);
            mFlPoint.addView(imageView);
        }
    }

    /**
     * 添加水印(文字和线)
     *
     * @param bitmap 图
     * @return
     */
    private Bitmap createWaterMaskBitmap(Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();   //创建一个bitmap
        Bitmap newb = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);// 创建一个新的和SRC长度宽度一样的位图   //将该图片作为画布
        Canvas canvas = new Canvas(newb);
        canvas.drawBitmap(bitmap, 0, 0, null);  //在画布 0，0坐标上开始绘制原始图片
        Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setColor(Color.parseColor("#FF4081"));
        mPaint.setTextSize(16f);
        //添加文字
        for (PointBean pointBean : imgPointBean.getPointBeanList()) {
            int margin = pointBean.getPointName().length();
            canvas.drawText(pointBean.getPointName(), pointBean.getOriginalMarginLeft() - margin * 10, pointBean.getOriginalMarginTop() - 8, mPaint); //在画布上绘制水印图片
        }
        //添加实线
        mPaint.setStrokeWidth(2);
        for (LineBean lineBean : imgPointBean.getLineList()) {
            PointBean startPoint = imgPointBean.getPointBeanList().get(lineBean.getStartIndex());
            PointBean endPoint = imgPointBean.getPointBeanList().get(lineBean.getEndIndex());
            canvas.drawLine(startPoint.getOriginalMarginLeft(), startPoint.getOriginalMarginTop()
                    , endPoint.getOriginalMarginLeft(), endPoint.getOriginalMarginTop(), mPaint);
        }

        canvas.save(Canvas.ALL_SAVE_FLAG);// 保存
        canvas.restore();// 存储
        return newb;
    }

    /**
     * 获取在容器里实际的位置
     *
     * @param layout        容器的高/宽
     * @param img           显示图的高/宽
     * @param pointViewSize 点的大小
     * @param scale         比例
     * @return
     */
    private int getMargin(int layout, int img, int pointViewSize, double scale) {
        return (int) ((layout - img) / 2.0 - pointViewSize / 2 + img * scale);
    }

    public static int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }
}
