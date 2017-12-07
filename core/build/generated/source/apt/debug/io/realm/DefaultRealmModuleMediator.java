package io.realm;


import android.util.JsonReader;
import io.realm.RealmObjectSchema;
import io.realm.internal.ColumnInfo;
import io.realm.internal.RealmObjectProxy;
import io.realm.internal.RealmProxyMediator;
import io.realm.internal.Row;
import io.realm.internal.SharedRealm;
import io.realm.internal.Table;
import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

@io.realm.annotations.RealmModule
class DefaultRealmModuleMediator extends RealmProxyMediator {

    private static final Set<Class<? extends RealmModel>> MODEL_CLASSES;
    static {
        Set<Class<? extends RealmModel>> modelClasses = new HashSet<Class<? extends RealmModel>>();
        modelClasses.add(com.dk.mp.core.entity.Jbxx.class);
        modelClasses.add(com.dk.mp.core.entity.OaApp.class);
        modelClasses.add(com.dk.mp.core.entity.Rcap.class);
        modelClasses.add(com.dk.mp.core.entity.XbPersons.class);
        modelClasses.add(com.dk.mp.core.entity.Department.class);
        modelClasses.add(com.dk.mp.core.entity.RcapDetail.class);
        MODEL_CLASSES = Collections.unmodifiableSet(modelClasses);
    }

    @Override
    public RealmObjectSchema createRealmObjectSchema(Class<? extends RealmModel> clazz, RealmSchema realmSchema) {
        checkClass(clazz);

        if (clazz.equals(com.dk.mp.core.entity.Jbxx.class)) {
            return io.realm.JbxxRealmProxy.createRealmObjectSchema(realmSchema);
        }
        if (clazz.equals(com.dk.mp.core.entity.OaApp.class)) {
            return io.realm.OaAppRealmProxy.createRealmObjectSchema(realmSchema);
        }
        if (clazz.equals(com.dk.mp.core.entity.Rcap.class)) {
            return io.realm.RcapRealmProxy.createRealmObjectSchema(realmSchema);
        }
        if (clazz.equals(com.dk.mp.core.entity.XbPersons.class)) {
            return io.realm.XbPersonsRealmProxy.createRealmObjectSchema(realmSchema);
        }
        if (clazz.equals(com.dk.mp.core.entity.Department.class)) {
            return io.realm.DepartmentRealmProxy.createRealmObjectSchema(realmSchema);
        }
        if (clazz.equals(com.dk.mp.core.entity.RcapDetail.class)) {
            return io.realm.RcapDetailRealmProxy.createRealmObjectSchema(realmSchema);
        }
        throw getMissingProxyClassException(clazz);
    }

    @Override
    public ColumnInfo validateTable(Class<? extends RealmModel> clazz, SharedRealm sharedRealm, boolean allowExtraColumns) {
        checkClass(clazz);

        if (clazz.equals(com.dk.mp.core.entity.Jbxx.class)) {
            return io.realm.JbxxRealmProxy.validateTable(sharedRealm, allowExtraColumns);
        }
        if (clazz.equals(com.dk.mp.core.entity.OaApp.class)) {
            return io.realm.OaAppRealmProxy.validateTable(sharedRealm, allowExtraColumns);
        }
        if (clazz.equals(com.dk.mp.core.entity.Rcap.class)) {
            return io.realm.RcapRealmProxy.validateTable(sharedRealm, allowExtraColumns);
        }
        if (clazz.equals(com.dk.mp.core.entity.XbPersons.class)) {
            return io.realm.XbPersonsRealmProxy.validateTable(sharedRealm, allowExtraColumns);
        }
        if (clazz.equals(com.dk.mp.core.entity.Department.class)) {
            return io.realm.DepartmentRealmProxy.validateTable(sharedRealm, allowExtraColumns);
        }
        if (clazz.equals(com.dk.mp.core.entity.RcapDetail.class)) {
            return io.realm.RcapDetailRealmProxy.validateTable(sharedRealm, allowExtraColumns);
        }
        throw getMissingProxyClassException(clazz);
    }

    @Override
    public List<String> getFieldNames(Class<? extends RealmModel> clazz) {
        checkClass(clazz);

        if (clazz.equals(com.dk.mp.core.entity.Jbxx.class)) {
            return io.realm.JbxxRealmProxy.getFieldNames();
        }
        if (clazz.equals(com.dk.mp.core.entity.OaApp.class)) {
            return io.realm.OaAppRealmProxy.getFieldNames();
        }
        if (clazz.equals(com.dk.mp.core.entity.Rcap.class)) {
            return io.realm.RcapRealmProxy.getFieldNames();
        }
        if (clazz.equals(com.dk.mp.core.entity.XbPersons.class)) {
            return io.realm.XbPersonsRealmProxy.getFieldNames();
        }
        if (clazz.equals(com.dk.mp.core.entity.Department.class)) {
            return io.realm.DepartmentRealmProxy.getFieldNames();
        }
        if (clazz.equals(com.dk.mp.core.entity.RcapDetail.class)) {
            return io.realm.RcapDetailRealmProxy.getFieldNames();
        }
        throw getMissingProxyClassException(clazz);
    }

    @Override
    public String getTableName(Class<? extends RealmModel> clazz) {
        checkClass(clazz);

        if (clazz.equals(com.dk.mp.core.entity.Jbxx.class)) {
            return io.realm.JbxxRealmProxy.getTableName();
        }
        if (clazz.equals(com.dk.mp.core.entity.OaApp.class)) {
            return io.realm.OaAppRealmProxy.getTableName();
        }
        if (clazz.equals(com.dk.mp.core.entity.Rcap.class)) {
            return io.realm.RcapRealmProxy.getTableName();
        }
        if (clazz.equals(com.dk.mp.core.entity.XbPersons.class)) {
            return io.realm.XbPersonsRealmProxy.getTableName();
        }
        if (clazz.equals(com.dk.mp.core.entity.Department.class)) {
            return io.realm.DepartmentRealmProxy.getTableName();
        }
        if (clazz.equals(com.dk.mp.core.entity.RcapDetail.class)) {
            return io.realm.RcapDetailRealmProxy.getTableName();
        }
        throw getMissingProxyClassException(clazz);
    }

    @Override
    public <E extends RealmModel> E newInstance(Class<E> clazz, Object baseRealm, Row row, ColumnInfo columnInfo, boolean acceptDefaultValue, List<String> excludeFields) {
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        try {
            objectContext.set((BaseRealm) baseRealm, row, columnInfo, acceptDefaultValue, excludeFields);
            checkClass(clazz);

            if (clazz.equals(com.dk.mp.core.entity.Jbxx.class)) {
                return clazz.cast(new io.realm.JbxxRealmProxy());
            }
            if (clazz.equals(com.dk.mp.core.entity.OaApp.class)) {
                return clazz.cast(new io.realm.OaAppRealmProxy());
            }
            if (clazz.equals(com.dk.mp.core.entity.Rcap.class)) {
                return clazz.cast(new io.realm.RcapRealmProxy());
            }
            if (clazz.equals(com.dk.mp.core.entity.XbPersons.class)) {
                return clazz.cast(new io.realm.XbPersonsRealmProxy());
            }
            if (clazz.equals(com.dk.mp.core.entity.Department.class)) {
                return clazz.cast(new io.realm.DepartmentRealmProxy());
            }
            if (clazz.equals(com.dk.mp.core.entity.RcapDetail.class)) {
                return clazz.cast(new io.realm.RcapDetailRealmProxy());
            }
            throw getMissingProxyClassException(clazz);
        } finally {
            objectContext.clear();
        }
    }

    @Override
    public Set<Class<? extends RealmModel>> getModelClasses() {
        return MODEL_CLASSES;
    }

    @Override
    public <E extends RealmModel> E copyOrUpdate(Realm realm, E obj, boolean update, Map<RealmModel, RealmObjectProxy> cache) {
        // This cast is correct because obj is either
        // generated by RealmProxy or the original type extending directly from RealmObject
        @SuppressWarnings("unchecked") Class<E> clazz = (Class<E>) ((obj instanceof RealmObjectProxy) ? obj.getClass().getSuperclass() : obj.getClass());

        if (clazz.equals(com.dk.mp.core.entity.Jbxx.class)) {
            return clazz.cast(io.realm.JbxxRealmProxy.copyOrUpdate(realm, (com.dk.mp.core.entity.Jbxx) obj, update, cache));
        }
        if (clazz.equals(com.dk.mp.core.entity.OaApp.class)) {
            return clazz.cast(io.realm.OaAppRealmProxy.copyOrUpdate(realm, (com.dk.mp.core.entity.OaApp) obj, update, cache));
        }
        if (clazz.equals(com.dk.mp.core.entity.Rcap.class)) {
            return clazz.cast(io.realm.RcapRealmProxy.copyOrUpdate(realm, (com.dk.mp.core.entity.Rcap) obj, update, cache));
        }
        if (clazz.equals(com.dk.mp.core.entity.XbPersons.class)) {
            return clazz.cast(io.realm.XbPersonsRealmProxy.copyOrUpdate(realm, (com.dk.mp.core.entity.XbPersons) obj, update, cache));
        }
        if (clazz.equals(com.dk.mp.core.entity.Department.class)) {
            return clazz.cast(io.realm.DepartmentRealmProxy.copyOrUpdate(realm, (com.dk.mp.core.entity.Department) obj, update, cache));
        }
        if (clazz.equals(com.dk.mp.core.entity.RcapDetail.class)) {
            return clazz.cast(io.realm.RcapDetailRealmProxy.copyOrUpdate(realm, (com.dk.mp.core.entity.RcapDetail) obj, update, cache));
        }
        throw getMissingProxyClassException(clazz);
    }

    @Override
    public void insert(Realm realm, RealmModel object, Map<RealmModel, Long> cache) {
        // This cast is correct because obj is either
        // generated by RealmProxy or the original type extending directly from RealmObject
        @SuppressWarnings("unchecked") Class<RealmModel> clazz = (Class<RealmModel>) ((object instanceof RealmObjectProxy) ? object.getClass().getSuperclass() : object.getClass());

        if (clazz.equals(com.dk.mp.core.entity.Jbxx.class)) {
            io.realm.JbxxRealmProxy.insert(realm, (com.dk.mp.core.entity.Jbxx) object, cache);
        } else if (clazz.equals(com.dk.mp.core.entity.OaApp.class)) {
            io.realm.OaAppRealmProxy.insert(realm, (com.dk.mp.core.entity.OaApp) object, cache);
        } else if (clazz.equals(com.dk.mp.core.entity.Rcap.class)) {
            io.realm.RcapRealmProxy.insert(realm, (com.dk.mp.core.entity.Rcap) object, cache);
        } else if (clazz.equals(com.dk.mp.core.entity.XbPersons.class)) {
            io.realm.XbPersonsRealmProxy.insert(realm, (com.dk.mp.core.entity.XbPersons) object, cache);
        } else if (clazz.equals(com.dk.mp.core.entity.Department.class)) {
            io.realm.DepartmentRealmProxy.insert(realm, (com.dk.mp.core.entity.Department) object, cache);
        } else if (clazz.equals(com.dk.mp.core.entity.RcapDetail.class)) {
            io.realm.RcapDetailRealmProxy.insert(realm, (com.dk.mp.core.entity.RcapDetail) object, cache);
        } else {
            throw getMissingProxyClassException(clazz);
        }
    }

    @Override
    public void insert(Realm realm, Collection<? extends RealmModel> objects) {
        Iterator<? extends RealmModel> iterator = objects.iterator();
        RealmModel object = null;
        Map<RealmModel, Long> cache = new HashMap<RealmModel, Long>(objects.size());
        if (iterator.hasNext()) {
            //  access the first element to figure out the clazz for the routing below
            object = iterator.next();
            // This cast is correct because obj is either
            // generated by RealmProxy or the original type extending directly from RealmObject
            @SuppressWarnings("unchecked") Class<RealmModel> clazz = (Class<RealmModel>) ((object instanceof RealmObjectProxy) ? object.getClass().getSuperclass() : object.getClass());

            if (clazz.equals(com.dk.mp.core.entity.Jbxx.class)) {
                io.realm.JbxxRealmProxy.insert(realm, (com.dk.mp.core.entity.Jbxx) object, cache);
            } else if (clazz.equals(com.dk.mp.core.entity.OaApp.class)) {
                io.realm.OaAppRealmProxy.insert(realm, (com.dk.mp.core.entity.OaApp) object, cache);
            } else if (clazz.equals(com.dk.mp.core.entity.Rcap.class)) {
                io.realm.RcapRealmProxy.insert(realm, (com.dk.mp.core.entity.Rcap) object, cache);
            } else if (clazz.equals(com.dk.mp.core.entity.XbPersons.class)) {
                io.realm.XbPersonsRealmProxy.insert(realm, (com.dk.mp.core.entity.XbPersons) object, cache);
            } else if (clazz.equals(com.dk.mp.core.entity.Department.class)) {
                io.realm.DepartmentRealmProxy.insert(realm, (com.dk.mp.core.entity.Department) object, cache);
            } else if (clazz.equals(com.dk.mp.core.entity.RcapDetail.class)) {
                io.realm.RcapDetailRealmProxy.insert(realm, (com.dk.mp.core.entity.RcapDetail) object, cache);
            } else {
                throw getMissingProxyClassException(clazz);
            }
            if (iterator.hasNext()) {
                if (clazz.equals(com.dk.mp.core.entity.Jbxx.class)) {
                    io.realm.JbxxRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.dk.mp.core.entity.OaApp.class)) {
                    io.realm.OaAppRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.dk.mp.core.entity.Rcap.class)) {
                    io.realm.RcapRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.dk.mp.core.entity.XbPersons.class)) {
                    io.realm.XbPersonsRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.dk.mp.core.entity.Department.class)) {
                    io.realm.DepartmentRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.dk.mp.core.entity.RcapDetail.class)) {
                    io.realm.RcapDetailRealmProxy.insert(realm, iterator, cache);
                } else {
                    throw getMissingProxyClassException(clazz);
                }
            }
        }
    }

    @Override
    public void insertOrUpdate(Realm realm, RealmModel obj, Map<RealmModel, Long> cache) {
        // This cast is correct because obj is either
        // generated by RealmProxy or the original type extending directly from RealmObject
        @SuppressWarnings("unchecked") Class<RealmModel> clazz = (Class<RealmModel>) ((obj instanceof RealmObjectProxy) ? obj.getClass().getSuperclass() : obj.getClass());

        if (clazz.equals(com.dk.mp.core.entity.Jbxx.class)) {
            io.realm.JbxxRealmProxy.insertOrUpdate(realm, (com.dk.mp.core.entity.Jbxx) obj, cache);
        } else if (clazz.equals(com.dk.mp.core.entity.OaApp.class)) {
            io.realm.OaAppRealmProxy.insertOrUpdate(realm, (com.dk.mp.core.entity.OaApp) obj, cache);
        } else if (clazz.equals(com.dk.mp.core.entity.Rcap.class)) {
            io.realm.RcapRealmProxy.insertOrUpdate(realm, (com.dk.mp.core.entity.Rcap) obj, cache);
        } else if (clazz.equals(com.dk.mp.core.entity.XbPersons.class)) {
            io.realm.XbPersonsRealmProxy.insertOrUpdate(realm, (com.dk.mp.core.entity.XbPersons) obj, cache);
        } else if (clazz.equals(com.dk.mp.core.entity.Department.class)) {
            io.realm.DepartmentRealmProxy.insertOrUpdate(realm, (com.dk.mp.core.entity.Department) obj, cache);
        } else if (clazz.equals(com.dk.mp.core.entity.RcapDetail.class)) {
            io.realm.RcapDetailRealmProxy.insertOrUpdate(realm, (com.dk.mp.core.entity.RcapDetail) obj, cache);
        } else {
            throw getMissingProxyClassException(clazz);
        }
    }

    @Override
    public void insertOrUpdate(Realm realm, Collection<? extends RealmModel> objects) {
        Iterator<? extends RealmModel> iterator = objects.iterator();
        RealmModel object = null;
        Map<RealmModel, Long> cache = new HashMap<RealmModel, Long>(objects.size());
        if (iterator.hasNext()) {
            //  access the first element to figure out the clazz for the routing below
            object = iterator.next();
            // This cast is correct because obj is either
            // generated by RealmProxy or the original type extending directly from RealmObject
            @SuppressWarnings("unchecked") Class<RealmModel> clazz = (Class<RealmModel>) ((object instanceof RealmObjectProxy) ? object.getClass().getSuperclass() : object.getClass());

            if (clazz.equals(com.dk.mp.core.entity.Jbxx.class)) {
                io.realm.JbxxRealmProxy.insertOrUpdate(realm, (com.dk.mp.core.entity.Jbxx) object, cache);
            } else if (clazz.equals(com.dk.mp.core.entity.OaApp.class)) {
                io.realm.OaAppRealmProxy.insertOrUpdate(realm, (com.dk.mp.core.entity.OaApp) object, cache);
            } else if (clazz.equals(com.dk.mp.core.entity.Rcap.class)) {
                io.realm.RcapRealmProxy.insertOrUpdate(realm, (com.dk.mp.core.entity.Rcap) object, cache);
            } else if (clazz.equals(com.dk.mp.core.entity.XbPersons.class)) {
                io.realm.XbPersonsRealmProxy.insertOrUpdate(realm, (com.dk.mp.core.entity.XbPersons) object, cache);
            } else if (clazz.equals(com.dk.mp.core.entity.Department.class)) {
                io.realm.DepartmentRealmProxy.insertOrUpdate(realm, (com.dk.mp.core.entity.Department) object, cache);
            } else if (clazz.equals(com.dk.mp.core.entity.RcapDetail.class)) {
                io.realm.RcapDetailRealmProxy.insertOrUpdate(realm, (com.dk.mp.core.entity.RcapDetail) object, cache);
            } else {
                throw getMissingProxyClassException(clazz);
            }
            if (iterator.hasNext()) {
                if (clazz.equals(com.dk.mp.core.entity.Jbxx.class)) {
                    io.realm.JbxxRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.dk.mp.core.entity.OaApp.class)) {
                    io.realm.OaAppRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.dk.mp.core.entity.Rcap.class)) {
                    io.realm.RcapRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.dk.mp.core.entity.XbPersons.class)) {
                    io.realm.XbPersonsRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.dk.mp.core.entity.Department.class)) {
                    io.realm.DepartmentRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.dk.mp.core.entity.RcapDetail.class)) {
                    io.realm.RcapDetailRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else {
                    throw getMissingProxyClassException(clazz);
                }
            }
        }
    }

    @Override
    public <E extends RealmModel> E createOrUpdateUsingJsonObject(Class<E> clazz, Realm realm, JSONObject json, boolean update)
        throws JSONException {
        checkClass(clazz);

        if (clazz.equals(com.dk.mp.core.entity.Jbxx.class)) {
            return clazz.cast(io.realm.JbxxRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(com.dk.mp.core.entity.OaApp.class)) {
            return clazz.cast(io.realm.OaAppRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(com.dk.mp.core.entity.Rcap.class)) {
            return clazz.cast(io.realm.RcapRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(com.dk.mp.core.entity.XbPersons.class)) {
            return clazz.cast(io.realm.XbPersonsRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(com.dk.mp.core.entity.Department.class)) {
            return clazz.cast(io.realm.DepartmentRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(com.dk.mp.core.entity.RcapDetail.class)) {
            return clazz.cast(io.realm.RcapDetailRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        throw getMissingProxyClassException(clazz);
    }

    @Override
    public <E extends RealmModel> E createUsingJsonStream(Class<E> clazz, Realm realm, JsonReader reader)
        throws IOException {
        checkClass(clazz);

        if (clazz.equals(com.dk.mp.core.entity.Jbxx.class)) {
            return clazz.cast(io.realm.JbxxRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(com.dk.mp.core.entity.OaApp.class)) {
            return clazz.cast(io.realm.OaAppRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(com.dk.mp.core.entity.Rcap.class)) {
            return clazz.cast(io.realm.RcapRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(com.dk.mp.core.entity.XbPersons.class)) {
            return clazz.cast(io.realm.XbPersonsRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(com.dk.mp.core.entity.Department.class)) {
            return clazz.cast(io.realm.DepartmentRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(com.dk.mp.core.entity.RcapDetail.class)) {
            return clazz.cast(io.realm.RcapDetailRealmProxy.createUsingJsonStream(realm, reader));
        }
        throw getMissingProxyClassException(clazz);
    }

    @Override
    public <E extends RealmModel> E createDetachedCopy(E realmObject, int maxDepth, Map<RealmModel, RealmObjectProxy.CacheData<RealmModel>> cache) {
        // This cast is correct because obj is either
        // generated by RealmProxy or the original type extending directly from RealmObject
        @SuppressWarnings("unchecked") Class<E> clazz = (Class<E>) realmObject.getClass().getSuperclass();

        if (clazz.equals(com.dk.mp.core.entity.Jbxx.class)) {
            return clazz.cast(io.realm.JbxxRealmProxy.createDetachedCopy((com.dk.mp.core.entity.Jbxx) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(com.dk.mp.core.entity.OaApp.class)) {
            return clazz.cast(io.realm.OaAppRealmProxy.createDetachedCopy((com.dk.mp.core.entity.OaApp) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(com.dk.mp.core.entity.Rcap.class)) {
            return clazz.cast(io.realm.RcapRealmProxy.createDetachedCopy((com.dk.mp.core.entity.Rcap) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(com.dk.mp.core.entity.XbPersons.class)) {
            return clazz.cast(io.realm.XbPersonsRealmProxy.createDetachedCopy((com.dk.mp.core.entity.XbPersons) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(com.dk.mp.core.entity.Department.class)) {
            return clazz.cast(io.realm.DepartmentRealmProxy.createDetachedCopy((com.dk.mp.core.entity.Department) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(com.dk.mp.core.entity.RcapDetail.class)) {
            return clazz.cast(io.realm.RcapDetailRealmProxy.createDetachedCopy((com.dk.mp.core.entity.RcapDetail) realmObject, 0, maxDepth, cache));
        }
        throw getMissingProxyClassException(clazz);
    }

}
