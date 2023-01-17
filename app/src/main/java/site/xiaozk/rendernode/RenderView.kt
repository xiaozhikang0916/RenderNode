package site.xiaozk.rendernode

import android.content.Context
import android.graphics.BlendMode
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.RenderNode
import android.util.AttributeSet

/**
 * @author: xiaozhikang
 * @mail: xiaozhikang0916@gmail.com
 * @create: 2022/12/19
 */
class RenderView
@JvmOverloads constructor(
    context: Context,
    attr: AttributeSet? = null,
    style: Int = 0,
) : BaseView(context, attr, style) {
    // 准备画笔，先画内容、再画蒙层，蒙层叠加在内容上，使用 DST_IN 模式
    private val paint = Paint().apply {
        blendMode = BlendMode.DST_IN
    }

    // 使用两个 RenderNode 分别绘制内容和蒙层，再将两个 RenderNode 混合
    private val headRender = RenderNode("head")
    private val headMaskRender = RenderNode("head_mask")

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        // 将两个render node设置初始位置和大小
        headRender.setPosition(0, 0, width, height)
        headMaskRender.setPosition(0, 0, width, height)

        // 设置分层绘制，并给蒙层设置paint
        headRender.setUseCompositingLayer(true, null)
        headMaskRender.setUseCompositingLayer(true, paint)

        // 记录蒙层内容
        headMaskRender.withRecording {
            mask?.draw(it)
        }

        // 内容实际绘制
        headRender.withRecording {
            // 先画内容
            head?.draw(it)
            // 再将蒙层叠加上来
            it.drawRenderNode(headMaskRender)
        }

        // 将混合结果输出到 view 中
        canvas?.drawRenderNode(headRender)
    }

}

// 一个辅助函数
inline fun RenderNode.withRecording(block: (canvas: Canvas) -> Unit) {
    block(this.beginRecording())
    this.endRecording()
}