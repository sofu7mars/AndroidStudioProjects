package pl.pollub.lab_13_ex_2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.provider.Telephony;
import android.telephony.SmsMessage;
import android.widget.Toast;

public class SMS_Receiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        SmsMessage[] msgs =
                Telephony.Sms.Intents.getMessagesFromIntent(intent);
        SmsMessage sms = msgs[0];
        MainActivity.setSmsDetails(sms.getOriginatingAddress(),
                sms.getMessageBody());
        Toast.makeText(context, "FROM: " + sms.getOriginatingAddress() +
                "\n" + "SMS: " + sms.getMessageBody(), Toast.LENGTH_LONG).show();
    }
}
