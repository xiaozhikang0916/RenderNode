package site.xiaozk.rendernode

import android.content.Context
import android.graphics.Rect
import android.graphics.RectF
import android.util.AttributeSet
import android.view.View
import androidx.core.content.ContextCompat
import site.xiaozk.rendernode.R

/**
 * @author: xiaozhikang
 * @mail: xiaozhikang0916@gmail.com
 * @create: 2023/1/6
 */
abstract class BaseView @JvmOverloads constructor(
    context: Context,
    attr: AttributeSet? = null,
    style: Int = 0,
) : View(context, attr, style) {
    val head = ContextCompat.getDrawable(context, R.drawable.head)
    val mask = ContextCompat.getDrawable(context, R.drawable.mask)

    val rect = Rect(0, 0, 270, 270)
    val rectF = RectF()
    val maskRect = Rect()
    val maskRectF = RectF()


    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        setMeasuredDimension(270, 270)
    }
    override fun onLayout(changed: Boolean, left: Int, top: Int, right: Int, bottom: Int) {
        super.onLayout(changed, left, top, right, bottom)
        maskRect.set(rect)
        maskRect.inset(30, 30)
        maskRectF.set(maskRect)
        rectF.set(rect)
        head?.bounds?.set(rect)
        mask?.bounds?.set(maskRect)
    }
}