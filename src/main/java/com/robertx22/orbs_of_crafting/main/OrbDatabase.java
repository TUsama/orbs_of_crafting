package com.robertx22.orbs_of_crafting.main;

import com.robertx22.library_of_exile.registry.Database;
import com.robertx22.library_of_exile.registry.ExileRegistryContainer;
import com.robertx22.library_of_exile.registry.ExileRegistryType;
import com.robertx22.library_of_exile.registry.SyncTime;
import com.robertx22.library_of_exile.registry.helpers.ExileDatabaseInit;
import com.robertx22.orbs_of_crafting.register.ExileCurrency;
import com.robertx22.orbs_of_crafting.register.mods.base.ItemModification;
import com.robertx22.orbs_of_crafting.register.reqs.base.ItemRequirement;
import net.minecraft.data.CachedOutput;

public class OrbDatabase extends ExileDatabaseInit {
    public static OrbDatabase INSTANCE = new OrbDatabase(OrbsRef.MODID);

    public static ExileRegistryType ITEM_MOD = ExileRegistryType.register(OrbsRef.MODID, "item_modification", 48, ItemModification.SERIALIZER, SyncTime.ON_LOGIN);
    public static ExileRegistryType ITEM_REQ = ExileRegistryType.register(OrbsRef.MODID, "item_requirement", 49, ItemRequirement.SERIALIZER, SyncTime.ON_LOGIN);
    public static ExileRegistryType CURRENCY = ExileRegistryType.register(OrbsRef.MODID, "currency", 50, ExileCurrency.SERIALIZER, SyncTime.ON_LOGIN);

    public OrbDatabase(String modid) {
        super(modid);
    }

    @Override
    public void initDatabases() {
        Database.addRegistry(new ExileRegistryContainer<>(OrbDatabase.ITEM_MOD, ""));
        Database.addRegistry(new ExileRegistryContainer<>(OrbDatabase.ITEM_REQ, ""));
        Database.addRegistry(new ExileRegistryContainer<>(OrbDatabase.CURRENCY, "socket_adder"));
    }

  
    public static ExileRegistryContainer<ExileCurrency> Currency() {
        return Database.getRegistry(CURRENCY);
    }

    public static ExileRegistryContainer<ItemModification> ItemMods() {
        return Database.getRegistry(ITEM_MOD);
    }

    public static ExileRegistryContainer<ItemRequirement> ItemReq() {
        return Database.getRegistry(ITEM_REQ);
    }


    @Override
    public void runDataGen(CachedOutput cache) {

        // todo
    }
}
