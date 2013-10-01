package edu.brown.cs.systems.screenbench;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends Activity {

    MyView mView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mView = new MyView(this);
        setContentView(mView);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.alpha:
                if (mView.alpha == 0x00)
                    mView.alpha = 0x80;
                else if (mView.alpha == 0x80)
                    mView.alpha = 0xff;
                else
                    mView.alpha = 0x00;
                // Call onDraw()
                mView.invalidate();
                Toast.makeText(MainActivity.this,
                        "Alpha set to " + mView.alpha, Toast.LENGTH_SHORT)
                        .show();
                return true;
            case R.id.red:
                if (mView.red == 0x00)
                    mView.red = 0x80;
                else if (mView.red == 0x80)
                    mView.red = 0xff;
                else
                    mView.red = 0x00;
                mView.invalidate();
                Toast.makeText(MainActivity.this, "Red set to " + mView.red,
                        Toast.LENGTH_SHORT).show();
                return true;
            case R.id.green:
                if (mView.green == 0x00)
                    mView.green = 0x80;
                else if (mView.green == 0x80)
                    mView.green = 0xff;
                else
                    mView.green = 0x00;
                mView.invalidate();
                Toast.makeText(MainActivity.this,
                        "Green set to " + mView.green, Toast.LENGTH_SHORT)
                        .show();
                return true;
            case R.id.blue:
                if (mView.blue == 0x00)
                    mView.blue = 0x80;
                else if (mView.blue == 0x80)
                    mView.blue = 0xff;
                else
                    mView.blue = 0x00;
                mView.invalidate();
                Toast.makeText(MainActivity.this, "Blue set to " + mView.blue,
                        Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    class MyView extends View {
        int red = 0xff;
        int green = 0xff;
        int blue = 0xff;
        int alpha = 0xff;

        MyView(Context context) {
            super(context);
        }

        @Override
        protected void onWindowVisibilityChanged(int visibility) {
            super.onWindowVisibilityChanged(visibility);
            if (visibility != View.VISIBLE) {
                return;
            }
        }

        @Override
        public void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            canvas.drawARGB(alpha, red, green, blue);
        }
    }
}
