# Ripple-progress
=================

Ripple progress is similar to the progressbar in GoogleNow application. This repo has example to demonstrate how to use awesome ripple progress.


Usage
-----
* Add the ProgressLayout.java and its dependencies to your project.

######Dynamically
Add a ProgressLayout to the xml layout:

```xml
     <com.incredibleandros.rippleprogress.ui.ProgressLayout
             android:id="@+id/progress"
             android:layout_width="match_parent"
             android:layout_height="4dp"
             android:layout_centerHorizontal="true"
             android:layout_alignTop="@id/layout" />
```
create a object for ProgressLayout & configure color codes you want

```java
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progress = (ProgressLayout) findViewById(R.id.progress);

        progress.setColorScheme(android.R.color.holo_blue_bright,
                        android.R.color.holo_green_light,
                        android.R.color.holo_orange_light,
                        android.R.color.holo_red_light);

        //...
    }
```