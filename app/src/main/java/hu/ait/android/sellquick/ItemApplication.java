package hu.ait.android.sellquick;

import android.app.Application;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by zhaozhaoxia on 4/7/18.
 */

public class ItemApplication extends Application{
    private Realm realm;

    public void onCreate(){
        super.onCreate();
        Realm.init(this);
    }

    public void openRealm(){
        RealmConfiguration config = new RealmConfiguration
                .Builder()
                .deleteRealmIfMigrationNeeded()
                .build();
        realm = Realm.getInstance(config);
    }

    public void closeRealm(){
        realm.close();
    }

    public Realm getRealm(){
        return realm;
    }
}
