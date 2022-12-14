package christmasPastryShop.repositories.interfaces;

import christmasPastryShop.entities.delicacies.interfaces.Delicacy;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

public class DelicacyRepositoryImpl implements DelicacyRepository<Delicacy>{
    private Map<String, Delicacy> models;

    public DelicacyRepositoryImpl() {
        this.models = new LinkedHashMap<>();
    }

    @Override
    public Delicacy getByName(String name) {
        return models.get(name);
    }

    @Override
    public Collection<Delicacy> getAll() {
        return models.values();
    }

    @Override
    public void add(Delicacy delicacy) {
        models.put(delicacy.getName(), delicacy);
    }
}
