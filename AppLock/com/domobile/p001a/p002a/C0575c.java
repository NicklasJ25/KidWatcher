package com.domobile.p001a.p002a;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender.SendIntentException;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v4.app.Fragment;
import android.support.v4.app.NotificationManagerCompat;
import android.text.TextUtils;
import android.util.Log;
import com.android.vending.billing.IInAppBillingService;
import com.android.vending.billing.IInAppBillingService.Stub;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;

public class C0575c {
    boolean f359a = false;
    String f360b = "IabHelper";
    boolean f361c = false;
    boolean f362d = false;
    boolean f363e = false;
    boolean f364f = false;
    String f365g = "";
    Context f366h;
    IInAppBillingService f367i;
    ServiceConnection f368j;
    int f369k;
    String f370l;
    String f371m = null;
    C0565b f372n;

    public interface C0561c {
        void mo2349a(C0576d c0576d);
    }

    public interface C0563d {
        void mo2350a(C0576d c0576d, C0577e c0577e);
    }

    public interface C0565b {
        void mo2351a(C0576d c0576d, C0578f c0578f);
    }

    public interface C0567a {
    }

    public C0575c(Context context, String str) {
        this.f366h = context.getApplicationContext();
        this.f371m = str;
        m521c("IAB helper created.");
    }

    public static String m502a(int i) {
        String[] split = "0:OK/1:User Canceled/2:Unknown/3:Billing Unavailable/4:Item unavailable/5:Developer Error/6:Error/7:Item Already Owned/8:Item not owned".split("/");
        String[] split2 = "0:OK/-1001:Remote exception during initialization/-1002:Bad response received/-1003:Purchase signature verification failed/-1004:Send intent failed/-1005:User cancelled/-1006:Unknown purchase response/-1007:Missing token/-1008:Unknown error/-1009:Subscriptions not available/-1010:Invalid consumption attempt".split("/");
        if (i > NotificationManagerCompat.IMPORTANCE_UNSPECIFIED) {
            return (i < 0 || i >= split.length) ? String.valueOf(i) + ":Unknown" : split[i];
        } else {
            int i2 = -1000 - i;
            return (i2 < 0 || i2 >= split2.length) ? String.valueOf(i) + ":Unknown IAB Helper Error" : split2[i2];
        }
    }

    private boolean m503d() {
        if (this.f362d) {
            m522d("IabHelper was disposed of, so it cannot be used.");
        }
        return this.f362d;
    }

    int m504a(Intent intent) {
        Object obj = intent.getExtras().get("RESPONSE_CODE");
        if (obj == null) {
            m522d("Intent with no response code, assuming OK (known issue)");
            return 0;
        } else if (obj instanceof Integer) {
            return ((Integer) obj).intValue();
        } else {
            if (obj instanceof Long) {
                return (int) ((Long) obj).longValue();
            }
            m522d("Unexpected type for intent response code.");
            m522d(obj.getClass().getName());
            throw new RuntimeException("Unexpected type for intent response code: " + obj.getClass().getName());
        }
    }

    int m505a(Bundle bundle) {
        Object obj = bundle.get("RESPONSE_CODE");
        if (obj == null) {
            m521c("Bundle with null response code, assuming OK (known issue)");
            return 0;
        } else if (obj instanceof Integer) {
            return ((Integer) obj).intValue();
        } else {
            if (obj instanceof Long) {
                return (int) ((Long) obj).longValue();
            }
            m522d("Unexpected type for bundle response code.");
            m522d(obj.getClass().getName());
            throw new RuntimeException("Unexpected type for bundle response code: " + obj.getClass().getName());
        }
    }

    int m506a(C0577e c0577e, String str) {
        m521c("Querying owned items, item type: " + str);
        m521c("Package name: " + this.f366h.getPackageName());
        String str2 = null;
        int i = 0;
        while (this.f367i != null) {
            m521c("Calling getPurchases with continuation token: " + str2);
            Bundle purchases = this.f367i.getPurchases(3, this.f366h.getPackageName(), str, str2);
            if (purchases == null) {
                return -1002;
            }
            int a = m505a(purchases);
            m521c("Owned items response: " + String.valueOf(a));
            if (a != 0) {
                m521c("getPurchases() failed: " + C0575c.m502a(a));
                return a;
            } else if (purchases.containsKey("INAPP_PURCHASE_ITEM_LIST") && purchases.containsKey("INAPP_PURCHASE_DATA_LIST") && purchases.containsKey("INAPP_DATA_SIGNATURE_LIST")) {
                ArrayList stringArrayList = purchases.getStringArrayList("INAPP_PURCHASE_ITEM_LIST");
                ArrayList stringArrayList2 = purchases.getStringArrayList("INAPP_PURCHASE_DATA_LIST");
                ArrayList stringArrayList3 = purchases.getStringArrayList("INAPP_DATA_SIGNATURE_LIST");
                int i2 = i;
                for (int i3 = 0; i3 < stringArrayList2.size(); i3++) {
                    str2 = (String) stringArrayList2.get(i3);
                    String str3 = (String) stringArrayList3.get(i3);
                    String str4 = (String) stringArrayList.get(i3);
                    if (C0579g.m538a(this.f371m, str2, str3)) {
                        m521c("Sku is owned: " + str4);
                        C0578f c0578f = new C0578f(str, str2, str3);
                        if (TextUtils.isEmpty(c0578f.m536c())) {
                            m523e("BUG: empty/null token!");
                            m521c("Purchase data: " + str2);
                        }
                        c0577e.m529a(c0578f);
                    } else {
                        m523e("Purchase signature verification **FAILED**. Not adding item.");
                        m521c("   Purchase data: " + str2);
                        m521c("   Signature: " + str3);
                        i2 = 1;
                    }
                }
                str2 = purchases.getString("INAPP_CONTINUATION_TOKEN");
                m521c("Continuation token: " + str2);
                if (TextUtils.isEmpty(str2)) {
                    return i2 != 0 ? -1003 : 0;
                } else {
                    i = i2;
                }
            } else {
                m522d("Bundle returned from getPurchases() doesn't contain required fields.");
                return -1002;
            }
        }
        return -1002;
    }

    int m507a(String str, C0577e c0577e, List<String> list) {
        m521c("Querying SKU details.");
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(c0577e.m533d(str));
        if (list != null) {
            for (String str2 : list) {
                if (!arrayList.contains(str2)) {
                    arrayList.add(str2);
                }
            }
        }
        if (arrayList.size() == 0) {
            m521c("queryPrices: nothing to do because there are no SKUs.");
            return 0;
        } else if (this.f367i == null) {
            return -1002;
        } else {
            Bundle bundle = new Bundle();
            bundle.putStringArrayList("ITEM_ID_LIST", arrayList);
            bundle = this.f367i.getSkuDetails(3, this.f366h.getPackageName(), str, bundle);
            if (bundle == null) {
                return -1002;
            }
            if (bundle.containsKey("DETAILS_LIST")) {
                Iterator it = bundle.getStringArrayList("DETAILS_LIST").iterator();
                while (it.hasNext()) {
                    C0580h c0580h = new C0580h(str, (String) it.next());
                    m521c("Got sku details: " + c0580h);
                    c0577e.m530a(c0580h);
                }
                return 0;
            }
            int a = m505a(bundle);
            if (a != 0) {
                m521c("getSkuDetails() failed: " + C0575c.m502a(a));
                return a;
            }
            m522d("getSkuDetails() returned a bundle with neither an error nor a detail list.");
            return -1002;
        }
    }

    public C0577e m508a(boolean z, List<String> list) {
        return m509a(z, (List) list, null);
    }

    public C0577e m509a(boolean z, List<String> list, List<String> list2) {
        if (m503d() || !m517a("queryInventory")) {
            return null;
        }
        try {
            C0577e c0577e = new C0577e();
            int a = m506a(c0577e, "inapp");
            if (a != 0) {
                throw new C0571b(a, "Error refreshing inventory (querying owned items).");
            }
            if (z) {
                a = m507a("inapp", c0577e, (List) list);
                if (a != 0) {
                    throw new C0571b(a, "Error refreshing inventory (querying prices of items).");
                }
            }
            if (!this.f363e) {
                return c0577e;
            }
            a = m506a(c0577e, "subs");
            if (a != 0) {
                throw new C0571b(a, "Error refreshing inventory (querying owned subscriptions).");
            } else if (!z) {
                return c0577e;
            } else {
                a = m507a("subs", c0577e, (List) list);
                if (a == 0) {
                    return c0577e;
                }
                throw new C0571b(a, "Error refreshing inventory (querying prices of subscriptions).");
            }
        } catch (Exception e) {
            throw new C0571b(-1001, "Remote exception while refreshing inventory.", e);
        } catch (Exception e2) {
            throw new C0571b(-1002, "Error parsing JSON response while refreshing inventory.", e2);
        } catch (Exception e22) {
            throw new C0571b(-1008, "Error.", e22);
        }
    }

    public void m510a() {
        m521c("Disposing.");
        this.f361c = false;
        if (this.f368j != null) {
            m521c("Unbinding from service.");
            if (this.f366h != null) {
                this.f366h.unbindService(this.f368j);
            }
        }
        this.f362d = true;
        this.f366h = null;
        this.f368j = null;
        this.f367i = null;
        this.f372n = null;
    }

    public void m511a(Activity activity, Fragment fragment, String str, int i, C0565b c0565b, String str2) {
        m512a(activity, fragment, str, "inapp", i, c0565b, str2);
    }

    public void m512a(Activity activity, Fragment fragment, String str, String str2, int i, C0565b c0565b, String str3) {
        C0576d c0576d;
        if (m503d() || !m517a("launchPurchaseFlow") || !m519b("launchPurchaseFlow")) {
            return;
        }
        if (!str2.equals("subs") || this.f363e) {
            try {
                m521c("Constructing buy intent for " + str + ", item type: " + str2);
                Bundle buyIntent = this.f367i.getBuyIntent(3, this.f366h.getPackageName(), str, str2, str3);
                int a = m505a(buyIntent);
                if (a != 0) {
                    m522d("Unable to buy item, Error response: " + C0575c.m502a(a));
                    m520c();
                    c0576d = new C0576d(a, "Unable to buy item");
                    if (c0565b != null) {
                        c0565b.mo2351a(c0576d, null);
                        return;
                    }
                    return;
                }
                PendingIntent pendingIntent = (PendingIntent) buyIntent.getParcelable("BUY_INTENT");
                m521c("Launching buy intent for " + str + ". Request code: " + i);
                this.f369k = i;
                this.f372n = c0565b;
                this.f370l = str2;
                if (fragment != null) {
                    fragment.startIntentSenderForResult(pendingIntent.getIntentSender(), i, new Intent(), Integer.valueOf(0).intValue(), Integer.valueOf(0).intValue(), Integer.valueOf(0).intValue(), null);
                    return;
                }
                activity.startIntentSenderForResult(pendingIntent.getIntentSender(), i, new Intent(), Integer.valueOf(0).intValue(), Integer.valueOf(0).intValue(), Integer.valueOf(0).intValue());
                return;
            } catch (SendIntentException e) {
                m522d("SendIntentException while launching purchase flow for sku " + str);
                e.printStackTrace();
                m520c();
                c0576d = new C0576d(-1004, "Failed to send intent.");
                if (c0565b != null) {
                    c0565b.mo2351a(c0576d, null);
                    return;
                }
                return;
            } catch (RemoteException e2) {
                m522d("RemoteException while launching purchase flow for sku " + str);
                e2.printStackTrace();
                m520c();
                c0576d = new C0576d(-1001, "Remote exception while starting purchase flow");
                if (c0565b != null) {
                    c0565b.mo2351a(c0576d, null);
                    return;
                }
                return;
            }
        }
        c0576d = new C0576d(-1009, "Subscriptions are not available.");
        m520c();
        if (c0565b != null) {
            c0565b.mo2351a(c0576d, null);
        }
    }

    public void m513a(final C0561c c0561c) {
        if (!m503d() && !this.f361c) {
            m521c("Starting in-app billing setup.");
            this.f368j = new ServiceConnection(this) {
                final /* synthetic */ C0575c f350b;

                public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                    if (!this.f350b.f362d) {
                        this.f350b.m521c("Billing service connected.");
                        this.f350b.f367i = Stub.asInterface(iBinder);
                        String packageName = this.f350b.f366h.getPackageName();
                        try {
                            this.f350b.m521c("Checking for in-app billing 3 support.");
                            int isBillingSupported = this.f350b.f367i.isBillingSupported(3, packageName, "inapp");
                            if (isBillingSupported != 0) {
                                if (c0561c != null) {
                                    c0561c.mo2349a(new C0576d(isBillingSupported, "Error checking for billing v3 support."));
                                }
                                this.f350b.f363e = false;
                                return;
                            }
                            this.f350b.m521c("In-app billing version 3 supported for " + packageName);
                            int isBillingSupported2 = this.f350b.f367i.isBillingSupported(3, packageName, "subs");
                            if (isBillingSupported2 == 0) {
                                this.f350b.m521c("Subscriptions AVAILABLE.");
                                this.f350b.f363e = true;
                            } else {
                                this.f350b.m521c("Subscriptions NOT AVAILABLE. Response: " + isBillingSupported2);
                            }
                            this.f350b.f361c = true;
                            if (c0561c != null) {
                                c0561c.mo2349a(new C0576d(0, "Setup successful."));
                            }
                        } catch (RemoteException e) {
                            if (c0561c != null) {
                                c0561c.mo2349a(new C0576d(-1001, "RemoteException while setting up in-app billing."));
                            }
                            e.printStackTrace();
                        }
                    }
                }

                public void onServiceDisconnected(ComponentName componentName) {
                    this.f350b.m521c("Billing service disconnected.");
                    this.f350b.f367i = null;
                }
            };
            Intent intent = new Intent("com.android.vending.billing.InAppBillingService.BIND");
            intent.setPackage("com.android.vending");
            List queryIntentServices = this.f366h.getPackageManager().queryIntentServices(intent, 0);
            if (queryIntentServices != null && !queryIntentServices.isEmpty()) {
                this.f366h.bindService(intent, this.f368j, 1);
            } else if (c0561c != null) {
                c0561c.mo2349a(new C0576d(3, "Billing service unavailable on device."));
            }
        }
    }

    public void m514a(boolean z) {
        this.f359a = z;
    }

    public void m515a(boolean z, List<String> list, C0563d c0563d) {
        final Handler handler = new Handler();
        if (!m503d() && m517a("queryInventory") && m519b("refresh inventory")) {
            final boolean z2 = z;
            final List<String> list2 = list;
            final C0563d c0563d2 = c0563d;
            new Thread(new Runnable(this) {
                final /* synthetic */ C0575c f358e;

                public void run() {
                    C0576d c0576d = new C0576d(0, "Inventory refresh successful.");
                    C0577e c0577e = null;
                    try {
                        c0577e = this.f358e.m508a(z2, list2);
                    } catch (C0571b e) {
                        c0576d = e.m501a();
                    }
                    this.f358e.m520c();
                    if (!this.f358e.f362d && c0563d2 != null) {
                        handler.post(new Runnable(this) {
                            final /* synthetic */ C05742 f353c;

                            public void run() {
                                c0563d2.mo2350a(c0576d, c0577e);
                            }
                        });
                    }
                }
            }).start();
        }
    }

    public boolean m516a(int i, int i2, Intent intent) {
        if (i != this.f369k || m503d() || !m517a("handleActivityResult")) {
            return false;
        }
        m520c();
        C0576d c0576d;
        if (intent == null) {
            m522d("Null data in IAB activity result.");
            c0576d = new C0576d(-1002, "Null data in IAB result");
            if (this.f372n != null) {
                this.f372n.mo2351a(c0576d, null);
            }
            return true;
        }
        int a = m504a(intent);
        String stringExtra = intent.getStringExtra("INAPP_PURCHASE_DATA");
        String stringExtra2 = intent.getStringExtra("INAPP_DATA_SIGNATURE");
        if (i2 == -1 && a == 0) {
            m521c("Successful resultcode from purchase activity.");
            m521c("Purchase data: " + stringExtra);
            m521c("Data signature: " + stringExtra2);
            m521c("Extras: " + intent.getExtras());
            m521c("Expected item type: " + this.f370l);
            if (stringExtra == null || stringExtra2 == null) {
                m522d("BUG: either purchaseData or dataSignature is null.");
                m521c("Extras: " + intent.getExtras().toString());
                c0576d = new C0576d(-1008, "IAB returned null purchaseData or dataSignature");
                if (this.f372n != null) {
                    this.f372n.mo2351a(c0576d, null);
                }
                return true;
            }
            try {
                C0578f c0578f = new C0578f(this.f370l, stringExtra, stringExtra2);
                String b = c0578f.m535b();
                if (C0579g.m538a(this.f371m, stringExtra, stringExtra2)) {
                    m521c("Purchase signature successfully verified.");
                    if (this.f372n != null) {
                        this.f372n.mo2351a(new C0576d(0, "Success"), c0578f);
                    }
                } else {
                    m522d("Purchase signature verification FAILED for sku " + b);
                    c0576d = new C0576d(-1003, "Signature verification failed for sku " + b);
                    if (this.f372n != null) {
                        this.f372n.mo2351a(c0576d, c0578f);
                    }
                    return true;
                }
            } catch (JSONException e) {
                m522d("Failed to parse purchase data.");
                e.printStackTrace();
                c0576d = new C0576d(-1002, "Failed to parse purchase data.");
                if (this.f372n != null) {
                    this.f372n.mo2351a(c0576d, null);
                }
                return true;
            }
        } else if (i2 == -1) {
            m521c("Result code was OK but in-app billing response was not OK: " + C0575c.m502a(a));
            if (this.f372n != null) {
                this.f372n.mo2351a(new C0576d(a, "Problem purchashing item."), null);
            }
        } else if (i2 == 0) {
            m521c("Purchase canceled - Response: " + C0575c.m502a(a));
            c0576d = new C0576d(-1005, "User canceled.");
            if (this.f372n != null) {
                this.f372n.mo2351a(c0576d, null);
            }
        } else {
            m522d("Purchase failed. Result code: " + Integer.toString(i2) + ". Response: " + C0575c.m502a(a));
            c0576d = new C0576d(-1006, "Unknown purchase response.");
            if (this.f372n != null) {
                this.f372n.mo2351a(c0576d, null);
            }
        }
        return true;
    }

    boolean m517a(String str) {
        if (!this.f361c) {
            m522d("Illegal state for operation (" + str + "): IAB helper is not set up.");
        }
        return this.f361c;
    }

    public boolean m518b() {
        return this.f363e;
    }

    boolean m519b(String str) {
        if (this.f364f) {
            m522d("Can't start async operation (" + str + ") because another async operation(" + this.f365g + ") is in progress.");
            return false;
        }
        this.f365g = str;
        this.f364f = true;
        m521c("Starting async operation: " + str);
        return true;
    }

    void m520c() {
        m521c("Ending async operation: " + this.f365g);
        this.f365g = "";
        this.f364f = false;
    }

    void m521c(String str) {
        if (this.f359a) {
            Log.d(this.f360b, str);
        }
    }

    void m522d(String str) {
        Log.e(this.f360b, "In-app billing error: " + str);
    }

    void m523e(String str) {
        Log.w(this.f360b, "In-app billing warning: " + str);
    }
}
