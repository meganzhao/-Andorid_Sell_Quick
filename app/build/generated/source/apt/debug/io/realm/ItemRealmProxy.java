package io.realm;


import android.annotation.TargetApi;
import android.os.Build;
import android.util.JsonReader;
import android.util.JsonToken;
import io.realm.RealmObjectSchema;
import io.realm.RealmSchema;
import io.realm.exceptions.RealmMigrationNeededException;
import io.realm.internal.ColumnInfo;
import io.realm.internal.LinkView;
import io.realm.internal.RealmObjectProxy;
import io.realm.internal.Row;
import io.realm.internal.SharedRealm;
import io.realm.internal.Table;
import io.realm.internal.android.JsonUtils;
import io.realm.log.RealmLog;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ItemRealmProxy extends hu.ait.android.sellquick.data.Item
    implements RealmObjectProxy, ItemRealmProxyInterface {

    static final class ItemColumnInfo extends ColumnInfo
        implements Cloneable {

        public long itemIDIndex;
        public long itemNameIndex;
        public long priceIndex;
        public long countDownIndex;

        ItemColumnInfo(String path, Table table) {
            final Map<String, Long> indicesMap = new HashMap<String, Long>(4);
            this.itemIDIndex = getValidColumnIndex(path, table, "Item", "itemID");
            indicesMap.put("itemID", this.itemIDIndex);
            this.itemNameIndex = getValidColumnIndex(path, table, "Item", "itemName");
            indicesMap.put("itemName", this.itemNameIndex);
            this.priceIndex = getValidColumnIndex(path, table, "Item", "price");
            indicesMap.put("price", this.priceIndex);
            this.countDownIndex = getValidColumnIndex(path, table, "Item", "countDown");
            indicesMap.put("countDown", this.countDownIndex);

            setIndicesMap(indicesMap);
        }

        @Override
        public final void copyColumnInfoFrom(ColumnInfo other) {
            final ItemColumnInfo otherInfo = (ItemColumnInfo) other;
            this.itemIDIndex = otherInfo.itemIDIndex;
            this.itemNameIndex = otherInfo.itemNameIndex;
            this.priceIndex = otherInfo.priceIndex;
            this.countDownIndex = otherInfo.countDownIndex;

            setIndicesMap(otherInfo.getIndicesMap());
        }

        @Override
        public final ItemColumnInfo clone() {
            return (ItemColumnInfo) super.clone();
        }

    }
    private ItemColumnInfo columnInfo;
    private ProxyState<hu.ait.android.sellquick.data.Item> proxyState;
    private static final List<String> FIELD_NAMES;
    static {
        List<String> fieldNames = new ArrayList<String>();
        fieldNames.add("itemID");
        fieldNames.add("itemName");
        fieldNames.add("price");
        fieldNames.add("countDown");
        FIELD_NAMES = Collections.unmodifiableList(fieldNames);
    }

    ItemRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (ItemColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<hu.ait.android.sellquick.data.Item>(this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
    }

    @SuppressWarnings("cast")
    public String realmGet$itemID() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.itemIDIndex);
    }

    public void realmSet$itemID(String value) {
        if (proxyState.isUnderConstruction()) {
            // default value of the primary key is always ignored.
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        throw new io.realm.exceptions.RealmException("Primary key field 'itemID' cannot be changed after object was created.");
    }

    @SuppressWarnings("cast")
    public String realmGet$itemName() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.itemNameIndex);
    }

    public void realmSet$itemName(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.itemNameIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.itemNameIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.itemNameIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.itemNameIndex, value);
    }

    @SuppressWarnings("cast")
    public float realmGet$price() {
        proxyState.getRealm$realm().checkIfValid();
        return (float) proxyState.getRow$realm().getFloat(columnInfo.priceIndex);
    }

    public void realmSet$price(float value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setFloat(columnInfo.priceIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setFloat(columnInfo.priceIndex, value);
    }

    @SuppressWarnings("cast")
    public int realmGet$countDown() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.countDownIndex);
    }

    public void realmSet$countDown(int value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.countDownIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.countDownIndex, value);
    }

    public static RealmObjectSchema createRealmObjectSchema(RealmSchema realmSchema) {
        if (!realmSchema.contains("Item")) {
            RealmObjectSchema realmObjectSchema = realmSchema.create("Item");
            realmObjectSchema.add(new Property("itemID", RealmFieldType.STRING, Property.PRIMARY_KEY, Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("itemName", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("price", RealmFieldType.FLOAT, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED));
            realmObjectSchema.add(new Property("countDown", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED));
            return realmObjectSchema;
        }
        return realmSchema.get("Item");
    }

    public static Table initTable(SharedRealm sharedRealm) {
        if (!sharedRealm.hasTable("class_Item")) {
            Table table = sharedRealm.getTable("class_Item");
            table.addColumn(RealmFieldType.STRING, "itemID", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "itemName", Table.NULLABLE);
            table.addColumn(RealmFieldType.FLOAT, "price", Table.NOT_NULLABLE);
            table.addColumn(RealmFieldType.INTEGER, "countDown", Table.NOT_NULLABLE);
            table.addSearchIndex(table.getColumnIndex("itemID"));
            table.setPrimaryKey("itemID");
            return table;
        }
        return sharedRealm.getTable("class_Item");
    }

    public static ItemColumnInfo validateTable(SharedRealm sharedRealm, boolean allowExtraColumns) {
        if (sharedRealm.hasTable("class_Item")) {
            Table table = sharedRealm.getTable("class_Item");
            final long columnCount = table.getColumnCount();
            if (columnCount != 4) {
                if (columnCount < 4) {
                    throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field count is less than expected - expected 4 but was " + columnCount);
                }
                if (allowExtraColumns) {
                    RealmLog.debug("Field count is more than expected - expected 4 but was %1$d", columnCount);
                } else {
                    throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field count is more than expected - expected 4 but was " + columnCount);
                }
            }
            Map<String, RealmFieldType> columnTypes = new HashMap<String, RealmFieldType>();
            for (long i = 0; i < columnCount; i++) {
                columnTypes.put(table.getColumnName(i), table.getColumnType(i));
            }

            final ItemColumnInfo columnInfo = new ItemColumnInfo(sharedRealm.getPath(), table);

            if (!table.hasPrimaryKey()) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Primary key not defined for field 'itemID' in existing Realm file. @PrimaryKey was added.");
            } else {
                if (table.getPrimaryKey() != columnInfo.itemIDIndex) {
                    throw new RealmMigrationNeededException(sharedRealm.getPath(), "Primary Key annotation definition was changed, from field " + table.getColumnName(table.getPrimaryKey()) + " to field itemID");
                }
            }

            if (!columnTypes.containsKey("itemID")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'itemID' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("itemID") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'itemID' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.itemIDIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(),"@PrimaryKey field 'itemID' does not support null values in the existing Realm file. Migrate using RealmObjectSchema.setNullable(), or mark the field as @Required.");
            }
            if (!table.hasSearchIndex(table.getColumnIndex("itemID"))) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Index not defined for field 'itemID' in existing Realm file. Either set @Index or migrate using io.realm.internal.Table.removeSearchIndex().");
            }
            if (!columnTypes.containsKey("itemName")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'itemName' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("itemName") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'itemName' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.itemNameIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'itemName' is required. Either set @Required to field 'itemName' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("price")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'price' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("price") != RealmFieldType.FLOAT) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'float' for field 'price' in existing Realm file.");
            }
            if (table.isColumnNullable(columnInfo.priceIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'price' does support null values in the existing Realm file. Use corresponding boxed type for field 'price' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("countDown")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'countDown' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("countDown") != RealmFieldType.INTEGER) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'int' for field 'countDown' in existing Realm file.");
            }
            if (table.isColumnNullable(columnInfo.countDownIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'countDown' does support null values in the existing Realm file. Use corresponding boxed type for field 'countDown' or migrate using RealmObjectSchema.setNullable().");
            }
            return columnInfo;
        } else {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "The 'Item' class is missing from the schema for this Realm.");
        }
    }

    public static String getTableName() {
        return "class_Item";
    }

    public static List<String> getFieldNames() {
        return FIELD_NAMES;
    }

    @SuppressWarnings("cast")
    public static hu.ait.android.sellquick.data.Item createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        hu.ait.android.sellquick.data.Item obj = null;
        if (update) {
            Table table = realm.getTable(hu.ait.android.sellquick.data.Item.class);
            long pkColumnIndex = table.getPrimaryKey();
            long rowIndex = Table.NO_MATCH;
            if (json.isNull("itemID")) {
                rowIndex = table.findFirstNull(pkColumnIndex);
            } else {
                rowIndex = table.findFirstString(pkColumnIndex, json.getString("itemID"));
            }
            if (rowIndex != Table.NO_MATCH) {
                final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
                try {
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.schema.getColumnInfo(hu.ait.android.sellquick.data.Item.class), false, Collections.<String> emptyList());
                    obj = new io.realm.ItemRealmProxy();
                } finally {
                    objectContext.clear();
                }
            }
        }
        if (obj == null) {
            if (json.has("itemID")) {
                if (json.isNull("itemID")) {
                    obj = (io.realm.ItemRealmProxy) realm.createObjectInternal(hu.ait.android.sellquick.data.Item.class, null, true, excludeFields);
                } else {
                    obj = (io.realm.ItemRealmProxy) realm.createObjectInternal(hu.ait.android.sellquick.data.Item.class, json.getString("itemID"), true, excludeFields);
                }
            } else {
                throw new IllegalArgumentException("JSON object doesn't have the primary key field 'itemID'.");
            }
        }
        if (json.has("itemName")) {
            if (json.isNull("itemName")) {
                ((ItemRealmProxyInterface) obj).realmSet$itemName(null);
            } else {
                ((ItemRealmProxyInterface) obj).realmSet$itemName((String) json.getString("itemName"));
            }
        }
        if (json.has("price")) {
            if (json.isNull("price")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'price' to null.");
            } else {
                ((ItemRealmProxyInterface) obj).realmSet$price((float) json.getDouble("price"));
            }
        }
        if (json.has("countDown")) {
            if (json.isNull("countDown")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'countDown' to null.");
            } else {
                ((ItemRealmProxyInterface) obj).realmSet$countDown((int) json.getInt("countDown"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static hu.ait.android.sellquick.data.Item createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        boolean jsonHasPrimaryKey = false;
        hu.ait.android.sellquick.data.Item obj = new hu.ait.android.sellquick.data.Item();
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (name.equals("itemID")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((ItemRealmProxyInterface) obj).realmSet$itemID(null);
                } else {
                    ((ItemRealmProxyInterface) obj).realmSet$itemID((String) reader.nextString());
                }
                jsonHasPrimaryKey = true;
            } else if (name.equals("itemName")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((ItemRealmProxyInterface) obj).realmSet$itemName(null);
                } else {
                    ((ItemRealmProxyInterface) obj).realmSet$itemName((String) reader.nextString());
                }
            } else if (name.equals("price")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'price' to null.");
                } else {
                    ((ItemRealmProxyInterface) obj).realmSet$price((float) reader.nextDouble());
                }
            } else if (name.equals("countDown")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'countDown' to null.");
                } else {
                    ((ItemRealmProxyInterface) obj).realmSet$countDown((int) reader.nextInt());
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        if (!jsonHasPrimaryKey) {
            throw new IllegalArgumentException("JSON object doesn't have the primary key field 'itemID'.");
        }
        obj = realm.copyToRealm(obj);
        return obj;
    }

    public static hu.ait.android.sellquick.data.Item copyOrUpdate(Realm realm, hu.ait.android.sellquick.data.Item object, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().threadId != realm.threadId) {
            throw new IllegalArgumentException("Objects which belong to Realm instances in other threads cannot be copied into this Realm instance.");
        }
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return object;
        }
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        RealmObjectProxy cachedRealmObject = cache.get(object);
        if (cachedRealmObject != null) {
            return (hu.ait.android.sellquick.data.Item) cachedRealmObject;
        } else {
            hu.ait.android.sellquick.data.Item realmObject = null;
            boolean canUpdate = update;
            if (canUpdate) {
                Table table = realm.getTable(hu.ait.android.sellquick.data.Item.class);
                long pkColumnIndex = table.getPrimaryKey();
                String value = ((ItemRealmProxyInterface) object).realmGet$itemID();
                long rowIndex = Table.NO_MATCH;
                if (value == null) {
                    rowIndex = table.findFirstNull(pkColumnIndex);
                } else {
                    rowIndex = table.findFirstString(pkColumnIndex, value);
                }
                if (rowIndex != Table.NO_MATCH) {
                    try {
                        objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.schema.getColumnInfo(hu.ait.android.sellquick.data.Item.class), false, Collections.<String> emptyList());
                        realmObject = new io.realm.ItemRealmProxy();
                        cache.put(object, (RealmObjectProxy) realmObject);
                    } finally {
                        objectContext.clear();
                    }
                } else {
                    canUpdate = false;
                }
            }

            if (canUpdate) {
                return update(realm, realmObject, object, cache);
            } else {
                return copy(realm, object, update, cache);
            }
        }
    }

    public static hu.ait.android.sellquick.data.Item copy(Realm realm, hu.ait.android.sellquick.data.Item newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (hu.ait.android.sellquick.data.Item) cachedRealmObject;
        } else {
            // rejecting default values to avoid creating unexpected objects from RealmModel/RealmList fields.
            hu.ait.android.sellquick.data.Item realmObject = realm.createObjectInternal(hu.ait.android.sellquick.data.Item.class, ((ItemRealmProxyInterface) newObject).realmGet$itemID(), false, Collections.<String>emptyList());
            cache.put(newObject, (RealmObjectProxy) realmObject);
            ((ItemRealmProxyInterface) realmObject).realmSet$itemName(((ItemRealmProxyInterface) newObject).realmGet$itemName());
            ((ItemRealmProxyInterface) realmObject).realmSet$price(((ItemRealmProxyInterface) newObject).realmGet$price());
            ((ItemRealmProxyInterface) realmObject).realmSet$countDown(((ItemRealmProxyInterface) newObject).realmGet$countDown());
            return realmObject;
        }
    }

    public static long insert(Realm realm, hu.ait.android.sellquick.data.Item object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(hu.ait.android.sellquick.data.Item.class);
        long tableNativePtr = table.getNativeTablePointer();
        ItemColumnInfo columnInfo = (ItemColumnInfo) realm.schema.getColumnInfo(hu.ait.android.sellquick.data.Item.class);
        long pkColumnIndex = table.getPrimaryKey();
        String primaryKeyValue = ((ItemRealmProxyInterface) object).realmGet$itemID();
        long rowIndex = Table.NO_MATCH;
        if (primaryKeyValue == null) {
            rowIndex = Table.nativeFindFirstNull(tableNativePtr, pkColumnIndex);
        } else {
            rowIndex = Table.nativeFindFirstString(tableNativePtr, pkColumnIndex, primaryKeyValue);
        }
        if (rowIndex == Table.NO_MATCH) {
            rowIndex = table.addEmptyRowWithPrimaryKey(primaryKeyValue, false);
        } else {
            Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
        }
        cache.put(object, rowIndex);
        String realmGet$itemName = ((ItemRealmProxyInterface)object).realmGet$itemName();
        if (realmGet$itemName != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.itemNameIndex, rowIndex, realmGet$itemName, false);
        }
        Table.nativeSetFloat(tableNativePtr, columnInfo.priceIndex, rowIndex, ((ItemRealmProxyInterface)object).realmGet$price(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.countDownIndex, rowIndex, ((ItemRealmProxyInterface)object).realmGet$countDown(), false);
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(hu.ait.android.sellquick.data.Item.class);
        long tableNativePtr = table.getNativeTablePointer();
        ItemColumnInfo columnInfo = (ItemColumnInfo) realm.schema.getColumnInfo(hu.ait.android.sellquick.data.Item.class);
        long pkColumnIndex = table.getPrimaryKey();
        hu.ait.android.sellquick.data.Item object = null;
        while (objects.hasNext()) {
            object = (hu.ait.android.sellquick.data.Item) objects.next();
            if(!cache.containsKey(object)) {
                if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                    cache.put(object, ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex());
                    continue;
                }
                String primaryKeyValue = ((ItemRealmProxyInterface) object).realmGet$itemID();
                long rowIndex = Table.NO_MATCH;
                if (primaryKeyValue == null) {
                    rowIndex = Table.nativeFindFirstNull(tableNativePtr, pkColumnIndex);
                } else {
                    rowIndex = Table.nativeFindFirstString(tableNativePtr, pkColumnIndex, primaryKeyValue);
                }
                if (rowIndex == Table.NO_MATCH) {
                    rowIndex = table.addEmptyRowWithPrimaryKey(primaryKeyValue, false);
                } else {
                    Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
                }
                cache.put(object, rowIndex);
                String realmGet$itemName = ((ItemRealmProxyInterface)object).realmGet$itemName();
                if (realmGet$itemName != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.itemNameIndex, rowIndex, realmGet$itemName, false);
                }
                Table.nativeSetFloat(tableNativePtr, columnInfo.priceIndex, rowIndex, ((ItemRealmProxyInterface)object).realmGet$price(), false);
                Table.nativeSetLong(tableNativePtr, columnInfo.countDownIndex, rowIndex, ((ItemRealmProxyInterface)object).realmGet$countDown(), false);
            }
        }
    }

    public static long insertOrUpdate(Realm realm, hu.ait.android.sellquick.data.Item object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(hu.ait.android.sellquick.data.Item.class);
        long tableNativePtr = table.getNativeTablePointer();
        ItemColumnInfo columnInfo = (ItemColumnInfo) realm.schema.getColumnInfo(hu.ait.android.sellquick.data.Item.class);
        long pkColumnIndex = table.getPrimaryKey();
        String primaryKeyValue = ((ItemRealmProxyInterface) object).realmGet$itemID();
        long rowIndex = Table.NO_MATCH;
        if (primaryKeyValue == null) {
            rowIndex = Table.nativeFindFirstNull(tableNativePtr, pkColumnIndex);
        } else {
            rowIndex = Table.nativeFindFirstString(tableNativePtr, pkColumnIndex, primaryKeyValue);
        }
        if (rowIndex == Table.NO_MATCH) {
            rowIndex = table.addEmptyRowWithPrimaryKey(primaryKeyValue, false);
        }
        cache.put(object, rowIndex);
        String realmGet$itemName = ((ItemRealmProxyInterface)object).realmGet$itemName();
        if (realmGet$itemName != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.itemNameIndex, rowIndex, realmGet$itemName, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.itemNameIndex, rowIndex, false);
        }
        Table.nativeSetFloat(tableNativePtr, columnInfo.priceIndex, rowIndex, ((ItemRealmProxyInterface)object).realmGet$price(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.countDownIndex, rowIndex, ((ItemRealmProxyInterface)object).realmGet$countDown(), false);
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(hu.ait.android.sellquick.data.Item.class);
        long tableNativePtr = table.getNativeTablePointer();
        ItemColumnInfo columnInfo = (ItemColumnInfo) realm.schema.getColumnInfo(hu.ait.android.sellquick.data.Item.class);
        long pkColumnIndex = table.getPrimaryKey();
        hu.ait.android.sellquick.data.Item object = null;
        while (objects.hasNext()) {
            object = (hu.ait.android.sellquick.data.Item) objects.next();
            if(!cache.containsKey(object)) {
                if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                    cache.put(object, ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex());
                    continue;
                }
                String primaryKeyValue = ((ItemRealmProxyInterface) object).realmGet$itemID();
                long rowIndex = Table.NO_MATCH;
                if (primaryKeyValue == null) {
                    rowIndex = Table.nativeFindFirstNull(tableNativePtr, pkColumnIndex);
                } else {
                    rowIndex = Table.nativeFindFirstString(tableNativePtr, pkColumnIndex, primaryKeyValue);
                }
                if (rowIndex == Table.NO_MATCH) {
                    rowIndex = table.addEmptyRowWithPrimaryKey(primaryKeyValue, false);
                }
                cache.put(object, rowIndex);
                String realmGet$itemName = ((ItemRealmProxyInterface)object).realmGet$itemName();
                if (realmGet$itemName != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.itemNameIndex, rowIndex, realmGet$itemName, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.itemNameIndex, rowIndex, false);
                }
                Table.nativeSetFloat(tableNativePtr, columnInfo.priceIndex, rowIndex, ((ItemRealmProxyInterface)object).realmGet$price(), false);
                Table.nativeSetLong(tableNativePtr, columnInfo.countDownIndex, rowIndex, ((ItemRealmProxyInterface)object).realmGet$countDown(), false);
            }
        }
    }

    public static hu.ait.android.sellquick.data.Item createDetachedCopy(hu.ait.android.sellquick.data.Item realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        hu.ait.android.sellquick.data.Item unmanagedObject;
        if (cachedObject != null) {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (hu.ait.android.sellquick.data.Item)cachedObject.object;
            } else {
                unmanagedObject = (hu.ait.android.sellquick.data.Item)cachedObject.object;
                cachedObject.minDepth = currentDepth;
            }
        } else {
            unmanagedObject = new hu.ait.android.sellquick.data.Item();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        }
        ((ItemRealmProxyInterface) unmanagedObject).realmSet$itemID(((ItemRealmProxyInterface) realmObject).realmGet$itemID());
        ((ItemRealmProxyInterface) unmanagedObject).realmSet$itemName(((ItemRealmProxyInterface) realmObject).realmGet$itemName());
        ((ItemRealmProxyInterface) unmanagedObject).realmSet$price(((ItemRealmProxyInterface) realmObject).realmGet$price());
        ((ItemRealmProxyInterface) unmanagedObject).realmSet$countDown(((ItemRealmProxyInterface) realmObject).realmGet$countDown());
        return unmanagedObject;
    }

    static hu.ait.android.sellquick.data.Item update(Realm realm, hu.ait.android.sellquick.data.Item realmObject, hu.ait.android.sellquick.data.Item newObject, Map<RealmModel, RealmObjectProxy> cache) {
        ((ItemRealmProxyInterface) realmObject).realmSet$itemName(((ItemRealmProxyInterface) newObject).realmGet$itemName());
        ((ItemRealmProxyInterface) realmObject).realmSet$price(((ItemRealmProxyInterface) newObject).realmGet$price());
        ((ItemRealmProxyInterface) realmObject).realmSet$countDown(((ItemRealmProxyInterface) newObject).realmGet$countDown());
        return realmObject;
    }

    @Override
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("Item = [");
        stringBuilder.append("{itemID:");
        stringBuilder.append(realmGet$itemID() != null ? realmGet$itemID() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{itemName:");
        stringBuilder.append(realmGet$itemName() != null ? realmGet$itemName() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{price:");
        stringBuilder.append(realmGet$price());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{countDown:");
        stringBuilder.append(realmGet$countDown());
        stringBuilder.append("}");
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    @Override
    public ProxyState realmGet$proxyState() {
        return proxyState;
    }

    @Override
    public int hashCode() {
        String realmName = proxyState.getRealm$realm().getPath();
        String tableName = proxyState.getRow$realm().getTable().getName();
        long rowIndex = proxyState.getRow$realm().getIndex();

        int result = 17;
        result = 31 * result + ((realmName != null) ? realmName.hashCode() : 0);
        result = 31 * result + ((tableName != null) ? tableName.hashCode() : 0);
        result = 31 * result + (int) (rowIndex ^ (rowIndex >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemRealmProxy aItem = (ItemRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aItem.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aItem.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aItem.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }

}
