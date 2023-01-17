package site.xiaozk.rendernode

import android.view.View
import android.view.ViewGroup

/**
 * @author: xiaozhikang
 * @mail: xiaozhikang0916@gmail.com
 * @create: 2023/1/6
 */
class RenderNodeListFragment: AbsDisplayFragment() {
    override fun inflateItemView(parent: ViewGroup): View {
        return RenderView(parent.context)
    }
}