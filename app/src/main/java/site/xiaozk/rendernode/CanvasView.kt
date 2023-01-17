package site.xiaozk.rendernode

import android.content.Context
import android.graphics.*
import android.util.AttributeSet

/**
 * @author: xiaozhikang
 * @mail: xiaozhikang0916@gmail.com
 * @create: 2022/12/19
 */
class CanvasView
@JvmOverloads constructor(
    context: Context,
    attr: AttributeSet? = null,
    style: Int = 0,
) : BaseView(context, attr, style) {

    private val maskPaint = Paint().apply {
        // 先画蒙层、再画内容，使用 SRC_IN 模式
        xfermode = PorterDuffXfermode(PorterDuff.Mode.SRC_IN)
    }
    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        // 保存原图图层，与画布上原有元素互不干扰
        val saveCount = canvas.saveLayer(maskRectF, null)
        mask?.draw(canvas)
        // 保存蒙层图层，在恢复时使用 maskPaint 中设置的混合模式进行像素混合
        val layerCount = canvas.saveLayer(rectF, maskPaint)
        head?.draw(canvas)

        // 恢复图层以应用像素混合
        canvas.restoreToCount(layerCount)
        canvas.restoreToCount(saveCount)
    }

}