package com.tophathacker.ioiostarter;

import android.os.Bundle;
import com.tophathacker.ioiostarter.R;
import ioio.lib.api.DigitalOutput;
import ioio.lib.api.exception.ConnectionLostException;
import ioio.lib.util.AbstractIOIOActivity;
import android.os.Bundle;
import android.widget.ToggleButton;

public class gui extends AbstractIOIOActivity {
	private ToggleButton button_;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        button_ = (ToggleButton) findViewById(R.id.toggleButton1);
    }
    
    
    
    
    
    
    class IOIOThread extends AbstractIOIOActivity.IOIOThread {
    	/** The on-board LED. */
		private DigitalOutput led_;

		/**
		 * Called every time a connection with IOIO has been established.
		 * Typically used to open pins.
		 * 
		 * @throws ConnectionLostException
		 *             When IOIO connection is lost.
		 * 
		 * @see ioio.lib.util.AbstractIOIOActivity.IOIOThread#setup()
		 */
		@Override
		protected void setup() throws ConnectionLostException {
			led_ = ioio_.openDigitalOutput(0, true);
		}

		/**
		 * Called repetitively while the IOIO is connected.
		 * 
		 * @throws ConnectionLostException
		 *             When IOIO connection is lost.
		 * 
		 * @see ioio.lib.util.AbstractIOIOActivity.IOIOThread#loop()
		 */
		@Override
		protected void loop() throws ConnectionLostException {
			led_.write(!button_.isChecked());
			try {
				sleep(100);
			} catch (InterruptedException e) {
			}
		}
    }
}