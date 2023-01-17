# RenderNode demo app

This is a demo app for my [blog](https://blog.xiaozk.site/blog/android-render-node).

## How to use

By clicking the buttons in main activity, you can view 2 pages rendered by `RenderNode` or `Canvas`, and collect performance data by `adb shell dumpsys gfxinfo site.xiaozk.rendernode`.

Change the number `4` in `app/src/main/res/layout/fragment_display.xml` Line 12 to see performance in different workload.
