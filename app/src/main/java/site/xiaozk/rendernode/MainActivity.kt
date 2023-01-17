package site.xiaozk.rendernode

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<View>(R.id.render_node).setOnClickListener {
            supportFragmentManager.beginTransaction().replace(R.id.fragment, RenderNodeListFragment()).commit()
        }
        findViewById<View>(R.id.canvas_view).setOnClickListener {
            supportFragmentManager.beginTransaction().replace(R.id.fragment, CanvasListFragment()).commit()
        }
    }
}