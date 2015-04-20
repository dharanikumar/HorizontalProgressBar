# HorizontalProgressBar
----------------------

HorizontalProgressBar is similar to the progressbar in GoogleNow application. It is simple, customizable horizontal indeterminate ProgressBar and easy to use. This repo has example usage.

![HorizontalProgressbar] (images/horizontalprogress.gif)

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
use the following method to show / hide progress
```java

    progress.setRefreshing(true);  //true  --  show progress
                                   //false --  hide progress


```
######Example
```java

        button.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        // TODO Auto-generated method stub
                        if (progress.isRefreshing()) {
                            progress.setRefreshing(false);
                        }
                        else{
                            progress.setRefreshing(true);
                        }
                    }
                });

```

