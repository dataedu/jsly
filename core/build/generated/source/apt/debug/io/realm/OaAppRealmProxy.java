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

public class OaAppRealmProxy extends com.dk.mp.core.entity.OaApp
    implements RealmObjectProxy, OaAppRealmProxyInterface {

    static final class OaAppColumnInfo extends ColumnInfo
        implements Cloneable {

        public long idIndex;
        public long nameIndex;
        public long labelIndex;
        public long countIndex;
        public long urlIndex;
        public long titleIndex;
        public long detailUrlIndex;
        public long bussessNameIndex;
        public long diyIndex;
        public long useridIndex;
        public long identityIndex;

        OaAppColumnInfo(String path, Table table) {
            final Map<String, Long> indicesMap = new HashMap<String, Long>(11);
            this.idIndex = getValidColumnIndex(path, table, "OaApp", "id");
            indicesMap.put("id", this.idIndex);
            this.nameIndex = getValidColumnIndex(path, table, "OaApp", "name");
            indicesMap.put("name", this.nameIndex);
            this.labelIndex = getValidColumnIndex(path, table, "OaApp", "label");
            indicesMap.put("label", this.labelIndex);
            this.countIndex = getValidColumnIndex(path, table, "OaApp", "count");
            indicesMap.put("count", this.countIndex);
            this.urlIndex = getValidColumnIndex(path, table, "OaApp", "url");
            indicesMap.put("url", this.urlIndex);
            this.titleIndex = getValidColumnIndex(path, table, "OaApp", "title");
            indicesMap.put("title", this.titleIndex);
            this.detailUrlIndex = getValidColumnIndex(path, table, "OaApp", "detailUrl");
            indicesMap.put("detailUrl", this.detailUrlIndex);
            this.bussessNameIndex = getValidColumnIndex(path, table, "OaApp", "bussessName");
            indicesMap.put("bussessName", this.bussessNameIndex);
            this.diyIndex = getValidColumnIndex(path, table, "OaApp", "diy");
            indicesMap.put("diy", this.diyIndex);
            this.useridIndex = getValidColumnIndex(path, table, "OaApp", "userid");
            indicesMap.put("userid", this.useridIndex);
            this.identityIndex = getValidColumnIndex(path, table, "OaApp", "identity");
            indicesMap.put("identity", this.identityIndex);

            setIndicesMap(indicesMap);
        }

        @Override
        public final void copyColumnInfoFrom(ColumnInfo other) {
            final OaAppColumnInfo otherInfo = (OaAppColumnInfo) other;
            this.idIndex = otherInfo.idIndex;
            this.nameIndex = otherInfo.nameIndex;
            this.labelIndex = otherInfo.labelIndex;
            this.countIndex = otherInfo.countIndex;
            this.urlIndex = otherInfo.urlIndex;
            this.titleIndex = otherInfo.titleIndex;
            this.detailUrlIndex = otherInfo.detailUrlIndex;
            this.bussessNameIndex = otherInfo.bussessNameIndex;
            this.diyIndex = otherInfo.diyIndex;
            this.useridIndex = otherInfo.useridIndex;
            this.identityIndex = otherInfo.identityIndex;

            setIndicesMap(otherInfo.getIndicesMap());
        }

        @Override
        public final OaAppColumnInfo clone() {
            return (OaAppColumnInfo) super.clone();
        }

    }
    private OaAppColumnInfo columnInfo;
    private ProxyState<com.dk.mp.core.entity.OaApp> proxyState;
    private static final List<String> FIELD_NAMES;
    static {
        List<String> fieldNames = new ArrayList<String>();
        fieldNames.add("id");
        fieldNames.add("name");
        fieldNames.add("label");
        fieldNames.add("count");
        fieldNames.add("url");
        fieldNames.add("title");
        fieldNames.add("detailUrl");
        fieldNames.add("bussessName");
        fieldNames.add("diy");
        fieldNames.add("userid");
        fieldNames.add("identity");
        FIELD_NAMES = Collections.unmodifiableList(fieldNames);
    }

    OaAppRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (OaAppColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<com.dk.mp.core.entity.OaApp>(this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
    }

    @Override
    @SuppressWarnings("cast")
    public long realmGet$id() {
        proxyState.getRealm$realm().checkIfValid();
        return (long) proxyState.getRow$realm().getLong(columnInfo.idIndex);
    }

    @Override
    public void realmSet$id(long value) {
        if (proxyState.isUnderConstruction()) {
            // default value of the primary key is always ignored.
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        throw new io.realm.exceptions.RealmException("Primary key field 'id' cannot be changed after object was created.");
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$name() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.nameIndex);
    }

    @Override
    public void realmSet$name(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.nameIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.nameIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.nameIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.nameIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$label() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.labelIndex);
    }

    @Override
    public void realmSet$label(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.labelIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.labelIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.labelIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.labelIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$count() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.countIndex);
    }

    @Override
    public void realmSet$count(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.countIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.countIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.countIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.countIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$url() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.urlIndex);
    }

    @Override
    public void realmSet$url(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.urlIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.urlIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.urlIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.urlIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$title() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.titleIndex);
    }

    @Override
    public void realmSet$title(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.titleIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.titleIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.titleIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.titleIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$detailUrl() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.detailUrlIndex);
    }

    @Override
    public void realmSet$detailUrl(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.detailUrlIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.detailUrlIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.detailUrlIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.detailUrlIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$bussessName() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.bussessNameIndex);
    }

    @Override
    public void realmSet$bussessName(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.bussessNameIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.bussessNameIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.bussessNameIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.bussessNameIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$diy() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.diyIndex);
    }

    @Override
    public void realmSet$diy(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.diyIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.diyIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.diyIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.diyIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$userid() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.useridIndex);
    }

    @Override
    public void realmSet$userid(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.useridIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.useridIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.useridIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.useridIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$identity() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.identityIndex);
    }

    @Override
    public void realmSet$identity(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.identityIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.identityIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.identityIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.identityIndex, value);
    }

    public static RealmObjectSchema createRealmObjectSchema(RealmSchema realmSchema) {
        if (!realmSchema.contains("OaApp")) {
            RealmObjectSchema realmObjectSchema = realmSchema.create("OaApp");
            realmObjectSchema.add("id", RealmFieldType.INTEGER, Property.PRIMARY_KEY, Property.INDEXED, Property.REQUIRED);
            realmObjectSchema.add("name", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("label", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("count", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("url", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("title", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("detailUrl", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("bussessName", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("diy", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("userid", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("identity", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            return realmObjectSchema;
        }
        return realmSchema.get("OaApp");
    }

    public static OaAppColumnInfo validateTable(SharedRealm sharedRealm, boolean allowExtraColumns) {
        if (!sharedRealm.hasTable("class_OaApp")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "The 'OaApp' class is missing from the schema for this Realm.");
        }
        Table table = sharedRealm.getTable("class_OaApp");
        final long columnCount = table.getColumnCount();
        if (columnCount != 11) {
            if (columnCount < 11) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field count is less than expected - expected 11 but was " + columnCount);
            }
            if (allowExtraColumns) {
                RealmLog.debug("Field count is more than expected - expected 11 but was %1$d", columnCount);
            } else {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field count is more than expected - expected 11 but was " + columnCount);
            }
        }
        Map<String, RealmFieldType> columnTypes = new HashMap<String, RealmFieldType>();
        for (long i = 0; i < columnCount; i++) {
            columnTypes.put(table.getColumnName(i), table.getColumnType(i));
        }

        final OaAppColumnInfo columnInfo = new OaAppColumnInfo(sharedRealm.getPath(), table);

        if (!table.hasPrimaryKey()) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Primary key not defined for field 'id' in existing Realm file. @PrimaryKey was added.");
        } else {
            if (table.getPrimaryKey() != columnInfo.idIndex) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Primary Key annotation definition was changed, from field " + table.getColumnName(table.getPrimaryKey()) + " to field id");
            }
        }

        if (!columnTypes.containsKey("id")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'id' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("id") != RealmFieldType.INTEGER) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'long' for field 'id' in existing Realm file.");
        }
        if (table.isColumnNullable(columnInfo.idIndex) && table.findFirstNull(columnInfo.idIndex) != Table.NO_MATCH) {
            throw new IllegalStateException("Cannot migrate an object with null value in field 'id'. Either maintain the same type for primary key field 'id', or remove the object with null value before migration.");
        }
        if (!table.hasSearchIndex(table.getColumnIndex("id"))) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Index not defined for field 'id' in existing Realm file. Either set @Index or migrate using io.realm.internal.Table.removeSearchIndex().");
        }
        if (!columnTypes.containsKey("name")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'name' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("name") != RealmFieldType.STRING) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'name' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.nameIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'name' is required. Either set @Required to field 'name' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("label")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'label' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("label") != RealmFieldType.STRING) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'label' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.labelIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'label' is required. Either set @Required to field 'label' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("count")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'count' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("count") != RealmFieldType.STRING) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'count' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.countIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'count' is required. Either set @Required to field 'count' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("url")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'url' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("url") != RealmFieldType.STRING) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'url' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.urlIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'url' is required. Either set @Required to field 'url' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("title")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'title' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("title") != RealmFieldType.STRING) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'title' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.titleIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'title' is required. Either set @Required to field 'title' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("detailUrl")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'detailUrl' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("detailUrl") != RealmFieldType.STRING) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'detailUrl' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.detailUrlIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'detailUrl' is required. Either set @Required to field 'detailUrl' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("bussessName")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'bussessName' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("bussessName") != RealmFieldType.STRING) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'bussessName' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.bussessNameIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'bussessName' is required. Either set @Required to field 'bussessName' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("diy")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'diy' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("diy") != RealmFieldType.STRING) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'diy' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.diyIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'diy' is required. Either set @Required to field 'diy' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("userid")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'userid' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("userid") != RealmFieldType.STRING) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'userid' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.useridIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'userid' is required. Either set @Required to field 'userid' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("identity")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'identity' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("identity") != RealmFieldType.STRING) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'identity' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.identityIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'identity' is required. Either set @Required to field 'identity' or migrate using RealmObjectSchema.setNullable().");
        }

        return columnInfo;
    }

    public static String getTableName() {
        return "class_OaApp";
    }

    public static List<String> getFieldNames() {
        return FIELD_NAMES;
    }

    @SuppressWarnings("cast")
    public static com.dk.mp.core.entity.OaApp createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        com.dk.mp.core.entity.OaApp obj = null;
        if (update) {
            Table table = realm.getTable(com.dk.mp.core.entity.OaApp.class);
            long pkColumnIndex = table.getPrimaryKey();
            long rowIndex = Table.NO_MATCH;
            if (!json.isNull("id")) {
                rowIndex = table.findFirstLong(pkColumnIndex, json.getLong("id"));
            }
            if (rowIndex != Table.NO_MATCH) {
                final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
                try {
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.schema.getColumnInfo(com.dk.mp.core.entity.OaApp.class), false, Collections.<String> emptyList());
                    obj = new io.realm.OaAppRealmProxy();
                } finally {
                    objectContext.clear();
                }
            }
        }
        if (obj == null) {
            if (json.has("id")) {
                if (json.isNull("id")) {
                    obj = (io.realm.OaAppRealmProxy) realm.createObjectInternal(com.dk.mp.core.entity.OaApp.class, null, true, excludeFields);
                } else {
                    obj = (io.realm.OaAppRealmProxy) realm.createObjectInternal(com.dk.mp.core.entity.OaApp.class, json.getLong("id"), true, excludeFields);
                }
            } else {
                throw new IllegalArgumentException("JSON object doesn't have the primary key field 'id'.");
            }
        }
        if (json.has("name")) {
            if (json.isNull("name")) {
                ((OaAppRealmProxyInterface) obj).realmSet$name(null);
            } else {
                ((OaAppRealmProxyInterface) obj).realmSet$name((String) json.getString("name"));
            }
        }
        if (json.has("label")) {
            if (json.isNull("label")) {
                ((OaAppRealmProxyInterface) obj).realmSet$label(null);
            } else {
                ((OaAppRealmProxyInterface) obj).realmSet$label((String) json.getString("label"));
            }
        }
        if (json.has("count")) {
            if (json.isNull("count")) {
                ((OaAppRealmProxyInterface) obj).realmSet$count(null);
            } else {
                ((OaAppRealmProxyInterface) obj).realmSet$count((String) json.getString("count"));
            }
        }
        if (json.has("url")) {
            if (json.isNull("url")) {
                ((OaAppRealmProxyInterface) obj).realmSet$url(null);
            } else {
                ((OaAppRealmProxyInterface) obj).realmSet$url((String) json.getString("url"));
            }
        }
        if (json.has("title")) {
            if (json.isNull("title")) {
                ((OaAppRealmProxyInterface) obj).realmSet$title(null);
            } else {
                ((OaAppRealmProxyInterface) obj).realmSet$title((String) json.getString("title"));
            }
        }
        if (json.has("detailUrl")) {
            if (json.isNull("detailUrl")) {
                ((OaAppRealmProxyInterface) obj).realmSet$detailUrl(null);
            } else {
                ((OaAppRealmProxyInterface) obj).realmSet$detailUrl((String) json.getString("detailUrl"));
            }
        }
        if (json.has("bussessName")) {
            if (json.isNull("bussessName")) {
                ((OaAppRealmProxyInterface) obj).realmSet$bussessName(null);
            } else {
                ((OaAppRealmProxyInterface) obj).realmSet$bussessName((String) json.getString("bussessName"));
            }
        }
        if (json.has("diy")) {
            if (json.isNull("diy")) {
                ((OaAppRealmProxyInterface) obj).realmSet$diy(null);
            } else {
                ((OaAppRealmProxyInterface) obj).realmSet$diy((String) json.getString("diy"));
            }
        }
        if (json.has("userid")) {
            if (json.isNull("userid")) {
                ((OaAppRealmProxyInterface) obj).realmSet$userid(null);
            } else {
                ((OaAppRealmProxyInterface) obj).realmSet$userid((String) json.getString("userid"));
            }
        }
        if (json.has("identity")) {
            if (json.isNull("identity")) {
                ((OaAppRealmProxyInterface) obj).realmSet$identity(null);
            } else {
                ((OaAppRealmProxyInterface) obj).realmSet$identity((String) json.getString("identity"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.dk.mp.core.entity.OaApp createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        boolean jsonHasPrimaryKey = false;
        com.dk.mp.core.entity.OaApp obj = new com.dk.mp.core.entity.OaApp();
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (false) {
            } else if (name.equals("id")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'id' to null.");
                } else {
                    ((OaAppRealmProxyInterface) obj).realmSet$id((long) reader.nextLong());
                }
                jsonHasPrimaryKey = true;
            } else if (name.equals("name")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((OaAppRealmProxyInterface) obj).realmSet$name(null);
                } else {
                    ((OaAppRealmProxyInterface) obj).realmSet$name((String) reader.nextString());
                }
            } else if (name.equals("label")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((OaAppRealmProxyInterface) obj).realmSet$label(null);
                } else {
                    ((OaAppRealmProxyInterface) obj).realmSet$label((String) reader.nextString());
                }
            } else if (name.equals("count")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((OaAppRealmProxyInterface) obj).realmSet$count(null);
                } else {
                    ((OaAppRealmProxyInterface) obj).realmSet$count((String) reader.nextString());
                }
            } else if (name.equals("url")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((OaAppRealmProxyInterface) obj).realmSet$url(null);
                } else {
                    ((OaAppRealmProxyInterface) obj).realmSet$url((String) reader.nextString());
                }
            } else if (name.equals("title")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((OaAppRealmProxyInterface) obj).realmSet$title(null);
                } else {
                    ((OaAppRealmProxyInterface) obj).realmSet$title((String) reader.nextString());
                }
            } else if (name.equals("detailUrl")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((OaAppRealmProxyInterface) obj).realmSet$detailUrl(null);
                } else {
                    ((OaAppRealmProxyInterface) obj).realmSet$detailUrl((String) reader.nextString());
                }
            } else if (name.equals("bussessName")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((OaAppRealmProxyInterface) obj).realmSet$bussessName(null);
                } else {
                    ((OaAppRealmProxyInterface) obj).realmSet$bussessName((String) reader.nextString());
                }
            } else if (name.equals("diy")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((OaAppRealmProxyInterface) obj).realmSet$diy(null);
                } else {
                    ((OaAppRealmProxyInterface) obj).realmSet$diy((String) reader.nextString());
                }
            } else if (name.equals("userid")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((OaAppRealmProxyInterface) obj).realmSet$userid(null);
                } else {
                    ((OaAppRealmProxyInterface) obj).realmSet$userid((String) reader.nextString());
                }
            } else if (name.equals("identity")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((OaAppRealmProxyInterface) obj).realmSet$identity(null);
                } else {
                    ((OaAppRealmProxyInterface) obj).realmSet$identity((String) reader.nextString());
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        if (!jsonHasPrimaryKey) {
            throw new IllegalArgumentException("JSON object doesn't have the primary key field 'id'.");
        }
        obj = realm.copyToRealm(obj);
        return obj;
    }

    public static com.dk.mp.core.entity.OaApp copyOrUpdate(Realm realm, com.dk.mp.core.entity.OaApp object, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().threadId != realm.threadId) {
            throw new IllegalArgumentException("Objects which belong to Realm instances in other threads cannot be copied into this Realm instance.");
        }
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return object;
        }
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        RealmObjectProxy cachedRealmObject = cache.get(object);
        if (cachedRealmObject != null) {
            return (com.dk.mp.core.entity.OaApp) cachedRealmObject;
        } else {
            com.dk.mp.core.entity.OaApp realmObject = null;
            boolean canUpdate = update;
            if (canUpdate) {
                Table table = realm.getTable(com.dk.mp.core.entity.OaApp.class);
                long pkColumnIndex = table.getPrimaryKey();
                long rowIndex = table.findFirstLong(pkColumnIndex, ((OaAppRealmProxyInterface) object).realmGet$id());
                if (rowIndex != Table.NO_MATCH) {
                    try {
                        objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.schema.getColumnInfo(com.dk.mp.core.entity.OaApp.class), false, Collections.<String> emptyList());
                        realmObject = new io.realm.OaAppRealmProxy();
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

    public static com.dk.mp.core.entity.OaApp copy(Realm realm, com.dk.mp.core.entity.OaApp newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.dk.mp.core.entity.OaApp) cachedRealmObject;
        } else {
            // rejecting default values to avoid creating unexpected objects from RealmModel/RealmList fields.
            com.dk.mp.core.entity.OaApp realmObject = realm.createObjectInternal(com.dk.mp.core.entity.OaApp.class, ((OaAppRealmProxyInterface) newObject).realmGet$id(), false, Collections.<String>emptyList());
            cache.put(newObject, (RealmObjectProxy) realmObject);
            ((OaAppRealmProxyInterface) realmObject).realmSet$name(((OaAppRealmProxyInterface) newObject).realmGet$name());
            ((OaAppRealmProxyInterface) realmObject).realmSet$label(((OaAppRealmProxyInterface) newObject).realmGet$label());
            ((OaAppRealmProxyInterface) realmObject).realmSet$count(((OaAppRealmProxyInterface) newObject).realmGet$count());
            ((OaAppRealmProxyInterface) realmObject).realmSet$url(((OaAppRealmProxyInterface) newObject).realmGet$url());
            ((OaAppRealmProxyInterface) realmObject).realmSet$title(((OaAppRealmProxyInterface) newObject).realmGet$title());
            ((OaAppRealmProxyInterface) realmObject).realmSet$detailUrl(((OaAppRealmProxyInterface) newObject).realmGet$detailUrl());
            ((OaAppRealmProxyInterface) realmObject).realmSet$bussessName(((OaAppRealmProxyInterface) newObject).realmGet$bussessName());
            ((OaAppRealmProxyInterface) realmObject).realmSet$diy(((OaAppRealmProxyInterface) newObject).realmGet$diy());
            ((OaAppRealmProxyInterface) realmObject).realmSet$userid(((OaAppRealmProxyInterface) newObject).realmGet$userid());
            ((OaAppRealmProxyInterface) realmObject).realmSet$identity(((OaAppRealmProxyInterface) newObject).realmGet$identity());
            return realmObject;
        }
    }

    public static long insert(Realm realm, com.dk.mp.core.entity.OaApp object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.dk.mp.core.entity.OaApp.class);
        long tableNativePtr = table.getNativeTablePointer();
        OaAppColumnInfo columnInfo = (OaAppColumnInfo) realm.schema.getColumnInfo(com.dk.mp.core.entity.OaApp.class);
        long pkColumnIndex = table.getPrimaryKey();
        long rowIndex = Table.NO_MATCH;
        Object primaryKeyValue = ((OaAppRealmProxyInterface) object).realmGet$id();
        if (primaryKeyValue != null) {
            rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((OaAppRealmProxyInterface) object).realmGet$id());
        }
        if (rowIndex == Table.NO_MATCH) {
            rowIndex = table.addEmptyRowWithPrimaryKey(((OaAppRealmProxyInterface) object).realmGet$id(), false);
        } else {
            Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
        }
        cache.put(object, rowIndex);
        String realmGet$name = ((OaAppRealmProxyInterface)object).realmGet$name();
        if (realmGet$name != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.nameIndex, rowIndex, realmGet$name, false);
        }
        String realmGet$label = ((OaAppRealmProxyInterface)object).realmGet$label();
        if (realmGet$label != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.labelIndex, rowIndex, realmGet$label, false);
        }
        String realmGet$count = ((OaAppRealmProxyInterface)object).realmGet$count();
        if (realmGet$count != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.countIndex, rowIndex, realmGet$count, false);
        }
        String realmGet$url = ((OaAppRealmProxyInterface)object).realmGet$url();
        if (realmGet$url != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.urlIndex, rowIndex, realmGet$url, false);
        }
        String realmGet$title = ((OaAppRealmProxyInterface)object).realmGet$title();
        if (realmGet$title != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.titleIndex, rowIndex, realmGet$title, false);
        }
        String realmGet$detailUrl = ((OaAppRealmProxyInterface)object).realmGet$detailUrl();
        if (realmGet$detailUrl != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.detailUrlIndex, rowIndex, realmGet$detailUrl, false);
        }
        String realmGet$bussessName = ((OaAppRealmProxyInterface)object).realmGet$bussessName();
        if (realmGet$bussessName != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.bussessNameIndex, rowIndex, realmGet$bussessName, false);
        }
        String realmGet$diy = ((OaAppRealmProxyInterface)object).realmGet$diy();
        if (realmGet$diy != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.diyIndex, rowIndex, realmGet$diy, false);
        }
        String realmGet$userid = ((OaAppRealmProxyInterface)object).realmGet$userid();
        if (realmGet$userid != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.useridIndex, rowIndex, realmGet$userid, false);
        }
        String realmGet$identity = ((OaAppRealmProxyInterface)object).realmGet$identity();
        if (realmGet$identity != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.identityIndex, rowIndex, realmGet$identity, false);
        }
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.dk.mp.core.entity.OaApp.class);
        long tableNativePtr = table.getNativeTablePointer();
        OaAppColumnInfo columnInfo = (OaAppColumnInfo) realm.schema.getColumnInfo(com.dk.mp.core.entity.OaApp.class);
        long pkColumnIndex = table.getPrimaryKey();
        com.dk.mp.core.entity.OaApp object = null;
        while (objects.hasNext()) {
            object = (com.dk.mp.core.entity.OaApp) objects.next();
            if(!cache.containsKey(object)) {
                if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                    cache.put(object, ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex());
                    continue;
                }
                long rowIndex = Table.NO_MATCH;
                Object primaryKeyValue = ((OaAppRealmProxyInterface) object).realmGet$id();
                if (primaryKeyValue != null) {
                    rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((OaAppRealmProxyInterface) object).realmGet$id());
                }
                if (rowIndex == Table.NO_MATCH) {
                    rowIndex = table.addEmptyRowWithPrimaryKey(((OaAppRealmProxyInterface) object).realmGet$id(), false);
                } else {
                    Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
                }
                cache.put(object, rowIndex);
                String realmGet$name = ((OaAppRealmProxyInterface)object).realmGet$name();
                if (realmGet$name != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.nameIndex, rowIndex, realmGet$name, false);
                }
                String realmGet$label = ((OaAppRealmProxyInterface)object).realmGet$label();
                if (realmGet$label != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.labelIndex, rowIndex, realmGet$label, false);
                }
                String realmGet$count = ((OaAppRealmProxyInterface)object).realmGet$count();
                if (realmGet$count != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.countIndex, rowIndex, realmGet$count, false);
                }
                String realmGet$url = ((OaAppRealmProxyInterface)object).realmGet$url();
                if (realmGet$url != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.urlIndex, rowIndex, realmGet$url, false);
                }
                String realmGet$title = ((OaAppRealmProxyInterface)object).realmGet$title();
                if (realmGet$title != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.titleIndex, rowIndex, realmGet$title, false);
                }
                String realmGet$detailUrl = ((OaAppRealmProxyInterface)object).realmGet$detailUrl();
                if (realmGet$detailUrl != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.detailUrlIndex, rowIndex, realmGet$detailUrl, false);
                }
                String realmGet$bussessName = ((OaAppRealmProxyInterface)object).realmGet$bussessName();
                if (realmGet$bussessName != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.bussessNameIndex, rowIndex, realmGet$bussessName, false);
                }
                String realmGet$diy = ((OaAppRealmProxyInterface)object).realmGet$diy();
                if (realmGet$diy != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.diyIndex, rowIndex, realmGet$diy, false);
                }
                String realmGet$userid = ((OaAppRealmProxyInterface)object).realmGet$userid();
                if (realmGet$userid != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.useridIndex, rowIndex, realmGet$userid, false);
                }
                String realmGet$identity = ((OaAppRealmProxyInterface)object).realmGet$identity();
                if (realmGet$identity != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.identityIndex, rowIndex, realmGet$identity, false);
                }
            }
        }
    }

    public static long insertOrUpdate(Realm realm, com.dk.mp.core.entity.OaApp object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.dk.mp.core.entity.OaApp.class);
        long tableNativePtr = table.getNativeTablePointer();
        OaAppColumnInfo columnInfo = (OaAppColumnInfo) realm.schema.getColumnInfo(com.dk.mp.core.entity.OaApp.class);
        long pkColumnIndex = table.getPrimaryKey();
        long rowIndex = Table.NO_MATCH;
        Object primaryKeyValue = ((OaAppRealmProxyInterface) object).realmGet$id();
        if (primaryKeyValue != null) {
            rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((OaAppRealmProxyInterface) object).realmGet$id());
        }
        if (rowIndex == Table.NO_MATCH) {
            rowIndex = table.addEmptyRowWithPrimaryKey(((OaAppRealmProxyInterface) object).realmGet$id(), false);
        }
        cache.put(object, rowIndex);
        String realmGet$name = ((OaAppRealmProxyInterface)object).realmGet$name();
        if (realmGet$name != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.nameIndex, rowIndex, realmGet$name, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.nameIndex, rowIndex, false);
        }
        String realmGet$label = ((OaAppRealmProxyInterface)object).realmGet$label();
        if (realmGet$label != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.labelIndex, rowIndex, realmGet$label, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.labelIndex, rowIndex, false);
        }
        String realmGet$count = ((OaAppRealmProxyInterface)object).realmGet$count();
        if (realmGet$count != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.countIndex, rowIndex, realmGet$count, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.countIndex, rowIndex, false);
        }
        String realmGet$url = ((OaAppRealmProxyInterface)object).realmGet$url();
        if (realmGet$url != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.urlIndex, rowIndex, realmGet$url, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.urlIndex, rowIndex, false);
        }
        String realmGet$title = ((OaAppRealmProxyInterface)object).realmGet$title();
        if (realmGet$title != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.titleIndex, rowIndex, realmGet$title, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.titleIndex, rowIndex, false);
        }
        String realmGet$detailUrl = ((OaAppRealmProxyInterface)object).realmGet$detailUrl();
        if (realmGet$detailUrl != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.detailUrlIndex, rowIndex, realmGet$detailUrl, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.detailUrlIndex, rowIndex, false);
        }
        String realmGet$bussessName = ((OaAppRealmProxyInterface)object).realmGet$bussessName();
        if (realmGet$bussessName != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.bussessNameIndex, rowIndex, realmGet$bussessName, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.bussessNameIndex, rowIndex, false);
        }
        String realmGet$diy = ((OaAppRealmProxyInterface)object).realmGet$diy();
        if (realmGet$diy != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.diyIndex, rowIndex, realmGet$diy, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.diyIndex, rowIndex, false);
        }
        String realmGet$userid = ((OaAppRealmProxyInterface)object).realmGet$userid();
        if (realmGet$userid != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.useridIndex, rowIndex, realmGet$userid, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.useridIndex, rowIndex, false);
        }
        String realmGet$identity = ((OaAppRealmProxyInterface)object).realmGet$identity();
        if (realmGet$identity != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.identityIndex, rowIndex, realmGet$identity, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.identityIndex, rowIndex, false);
        }
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.dk.mp.core.entity.OaApp.class);
        long tableNativePtr = table.getNativeTablePointer();
        OaAppColumnInfo columnInfo = (OaAppColumnInfo) realm.schema.getColumnInfo(com.dk.mp.core.entity.OaApp.class);
        long pkColumnIndex = table.getPrimaryKey();
        com.dk.mp.core.entity.OaApp object = null;
        while (objects.hasNext()) {
            object = (com.dk.mp.core.entity.OaApp) objects.next();
            if(!cache.containsKey(object)) {
                if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                    cache.put(object, ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex());
                    continue;
                }
                long rowIndex = Table.NO_MATCH;
                Object primaryKeyValue = ((OaAppRealmProxyInterface) object).realmGet$id();
                if (primaryKeyValue != null) {
                    rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((OaAppRealmProxyInterface) object).realmGet$id());
                }
                if (rowIndex == Table.NO_MATCH) {
                    rowIndex = table.addEmptyRowWithPrimaryKey(((OaAppRealmProxyInterface) object).realmGet$id(), false);
                }
                cache.put(object, rowIndex);
                String realmGet$name = ((OaAppRealmProxyInterface)object).realmGet$name();
                if (realmGet$name != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.nameIndex, rowIndex, realmGet$name, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.nameIndex, rowIndex, false);
                }
                String realmGet$label = ((OaAppRealmProxyInterface)object).realmGet$label();
                if (realmGet$label != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.labelIndex, rowIndex, realmGet$label, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.labelIndex, rowIndex, false);
                }
                String realmGet$count = ((OaAppRealmProxyInterface)object).realmGet$count();
                if (realmGet$count != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.countIndex, rowIndex, realmGet$count, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.countIndex, rowIndex, false);
                }
                String realmGet$url = ((OaAppRealmProxyInterface)object).realmGet$url();
                if (realmGet$url != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.urlIndex, rowIndex, realmGet$url, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.urlIndex, rowIndex, false);
                }
                String realmGet$title = ((OaAppRealmProxyInterface)object).realmGet$title();
                if (realmGet$title != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.titleIndex, rowIndex, realmGet$title, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.titleIndex, rowIndex, false);
                }
                String realmGet$detailUrl = ((OaAppRealmProxyInterface)object).realmGet$detailUrl();
                if (realmGet$detailUrl != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.detailUrlIndex, rowIndex, realmGet$detailUrl, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.detailUrlIndex, rowIndex, false);
                }
                String realmGet$bussessName = ((OaAppRealmProxyInterface)object).realmGet$bussessName();
                if (realmGet$bussessName != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.bussessNameIndex, rowIndex, realmGet$bussessName, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.bussessNameIndex, rowIndex, false);
                }
                String realmGet$diy = ((OaAppRealmProxyInterface)object).realmGet$diy();
                if (realmGet$diy != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.diyIndex, rowIndex, realmGet$diy, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.diyIndex, rowIndex, false);
                }
                String realmGet$userid = ((OaAppRealmProxyInterface)object).realmGet$userid();
                if (realmGet$userid != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.useridIndex, rowIndex, realmGet$userid, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.useridIndex, rowIndex, false);
                }
                String realmGet$identity = ((OaAppRealmProxyInterface)object).realmGet$identity();
                if (realmGet$identity != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.identityIndex, rowIndex, realmGet$identity, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.identityIndex, rowIndex, false);
                }
            }
        }
    }

    public static com.dk.mp.core.entity.OaApp createDetachedCopy(com.dk.mp.core.entity.OaApp realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.dk.mp.core.entity.OaApp unmanagedObject;
        if (cachedObject != null) {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.dk.mp.core.entity.OaApp)cachedObject.object;
            } else {
                unmanagedObject = (com.dk.mp.core.entity.OaApp)cachedObject.object;
                cachedObject.minDepth = currentDepth;
            }
        } else {
            unmanagedObject = new com.dk.mp.core.entity.OaApp();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        }
        ((OaAppRealmProxyInterface) unmanagedObject).realmSet$id(((OaAppRealmProxyInterface) realmObject).realmGet$id());
        ((OaAppRealmProxyInterface) unmanagedObject).realmSet$name(((OaAppRealmProxyInterface) realmObject).realmGet$name());
        ((OaAppRealmProxyInterface) unmanagedObject).realmSet$label(((OaAppRealmProxyInterface) realmObject).realmGet$label());
        ((OaAppRealmProxyInterface) unmanagedObject).realmSet$count(((OaAppRealmProxyInterface) realmObject).realmGet$count());
        ((OaAppRealmProxyInterface) unmanagedObject).realmSet$url(((OaAppRealmProxyInterface) realmObject).realmGet$url());
        ((OaAppRealmProxyInterface) unmanagedObject).realmSet$title(((OaAppRealmProxyInterface) realmObject).realmGet$title());
        ((OaAppRealmProxyInterface) unmanagedObject).realmSet$detailUrl(((OaAppRealmProxyInterface) realmObject).realmGet$detailUrl());
        ((OaAppRealmProxyInterface) unmanagedObject).realmSet$bussessName(((OaAppRealmProxyInterface) realmObject).realmGet$bussessName());
        ((OaAppRealmProxyInterface) unmanagedObject).realmSet$diy(((OaAppRealmProxyInterface) realmObject).realmGet$diy());
        ((OaAppRealmProxyInterface) unmanagedObject).realmSet$userid(((OaAppRealmProxyInterface) realmObject).realmGet$userid());
        ((OaAppRealmProxyInterface) unmanagedObject).realmSet$identity(((OaAppRealmProxyInterface) realmObject).realmGet$identity());
        return unmanagedObject;
    }

    static com.dk.mp.core.entity.OaApp update(Realm realm, com.dk.mp.core.entity.OaApp realmObject, com.dk.mp.core.entity.OaApp newObject, Map<RealmModel, RealmObjectProxy> cache) {
        ((OaAppRealmProxyInterface) realmObject).realmSet$name(((OaAppRealmProxyInterface) newObject).realmGet$name());
        ((OaAppRealmProxyInterface) realmObject).realmSet$label(((OaAppRealmProxyInterface) newObject).realmGet$label());
        ((OaAppRealmProxyInterface) realmObject).realmSet$count(((OaAppRealmProxyInterface) newObject).realmGet$count());
        ((OaAppRealmProxyInterface) realmObject).realmSet$url(((OaAppRealmProxyInterface) newObject).realmGet$url());
        ((OaAppRealmProxyInterface) realmObject).realmSet$title(((OaAppRealmProxyInterface) newObject).realmGet$title());
        ((OaAppRealmProxyInterface) realmObject).realmSet$detailUrl(((OaAppRealmProxyInterface) newObject).realmGet$detailUrl());
        ((OaAppRealmProxyInterface) realmObject).realmSet$bussessName(((OaAppRealmProxyInterface) newObject).realmGet$bussessName());
        ((OaAppRealmProxyInterface) realmObject).realmSet$diy(((OaAppRealmProxyInterface) newObject).realmGet$diy());
        ((OaAppRealmProxyInterface) realmObject).realmSet$userid(((OaAppRealmProxyInterface) newObject).realmGet$userid());
        ((OaAppRealmProxyInterface) realmObject).realmSet$identity(((OaAppRealmProxyInterface) newObject).realmGet$identity());
        return realmObject;
    }

    @Override
    @SuppressWarnings("ArrayToString")
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("OaApp = [");
        stringBuilder.append("{id:");
        stringBuilder.append(realmGet$id());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{name:");
        stringBuilder.append(realmGet$name() != null ? realmGet$name() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{label:");
        stringBuilder.append(realmGet$label() != null ? realmGet$label() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{count:");
        stringBuilder.append(realmGet$count() != null ? realmGet$count() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{url:");
        stringBuilder.append(realmGet$url() != null ? realmGet$url() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{title:");
        stringBuilder.append(realmGet$title() != null ? realmGet$title() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{detailUrl:");
        stringBuilder.append(realmGet$detailUrl() != null ? realmGet$detailUrl() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{bussessName:");
        stringBuilder.append(realmGet$bussessName() != null ? realmGet$bussessName() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{diy:");
        stringBuilder.append(realmGet$diy() != null ? realmGet$diy() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{userid:");
        stringBuilder.append(realmGet$userid() != null ? realmGet$userid() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{identity:");
        stringBuilder.append(realmGet$identity() != null ? realmGet$identity() : "null");
        stringBuilder.append("}");
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    @Override
    public ProxyState<?> realmGet$proxyState() {
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
        OaAppRealmProxy aOaApp = (OaAppRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aOaApp.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aOaApp.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aOaApp.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }

}
