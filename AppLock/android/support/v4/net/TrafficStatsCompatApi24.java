package android.support.v4.net;

import android.annotation.TargetApi;
import android.net.TrafficStats;
import android.support.annotation.RequiresApi;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;
import java.net.DatagramSocket;

@TargetApi(24)
@RequiresApi(24)
@RestrictTo({Scope.LIBRARY_GROUP})
public class TrafficStatsCompatApi24 {
    public static void tagDatagramSocket(DatagramSocket datagramSocket) {
        TrafficStats.tagDatagramSocket(datagramSocket);
    }

    public static void untagDatagramSocket(DatagramSocket datagramSocket) {
        TrafficStats.untagDatagramSocket(datagramSocket);
    }
}
