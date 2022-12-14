package christmasPastryShop.repositories.interfaces;

import christmasPastryShop.entities.cocktails.interfaces.Cocktail;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

public class CocktailRepositoryImpl implements CocktailRepository<Cocktail>{
    private Map<String, Cocktail> models;

    public CocktailRepositoryImpl() {
        this.models = new LinkedHashMap<>();
    }

    @Override
    public Cocktail getByName(String name) {
        return models.get(name);
    }

    @Override
    public Collection<Cocktail> getAll() {
        return models.values();
    }

    @Override
    public void add(Cocktail cocktail) {
        models.put(cocktail.getName(), cocktail);
    }
}
