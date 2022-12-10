package goldDigger.core;

import goldDigger.models.discoverer.Anthropologist;
import goldDigger.models.discoverer.Archaeologist;
import goldDigger.models.discoverer.Discoverer;
import goldDigger.models.discoverer.Geologist;
import goldDigger.models.operation.Operation;
import goldDigger.models.operation.OperationImpl;
import goldDigger.models.spot.Spot;
import goldDigger.models.spot.SpotImpl;
import goldDigger.repositories.DiscovererRepository;
import goldDigger.repositories.Repository;
import goldDigger.repositories.SpotRepository;

import java.util.List;
import java.util.stream.Collectors;

import static goldDigger.common.ConstantMessages.*;
import static goldDigger.common.ExceptionMessages.*;

public class ControllerImpl implements Controller{
     private Repository<Discoverer> discovererRepository;
     private Repository<Spot> spotsRepository;
     private int spotsCount = 0;

    public ControllerImpl() {
        discovererRepository = new DiscovererRepository();
        spotsRepository = new SpotRepository();
    }

    @Override
    public String addDiscoverer(String kind, String discovererName) {
        Discoverer discoverer;
        if (kind.equals("Archaeologist")){
            discoverer = new Archaeologist(discovererName);
        } else if (kind.equals("Anthropologist")) {
            discoverer = new Anthropologist(discovererName);
        } else if (kind.equals("Geologist")) {
            discoverer = new Geologist(discovererName);
        }else {
            throw new IllegalArgumentException (DISCOVERER_INVALID_KIND);
        }


        discovererRepository.add(discoverer);

        return String.format(DISCOVERER_ADDED,kind, discovererName);
    }

    @Override
    public String addSpot(String spotName, String... exhibits) {
        SpotImpl spot = new SpotImpl(spotName);
        for (String exhibit : exhibits) {
            spot.getExhibits().add(exhibit);
        }
        spotsRepository.add(spot);

        return String.format(SPOT_ADDED, spotName);
    }

    @Override
    public String excludeDiscoverer(String discovererName) {
        Discoverer discovererToExclude = discovererRepository.byName(discovererName);
        if (discovererToExclude == null){
            String ms = String.format(DISCOVERER_DOES_NOT_EXIST, discovererName);
            throw new IllegalArgumentException(ms);
        }
        discovererRepository.remove(discovererToExclude);

        return String.format(DISCOVERER_EXCLUDE, discovererName);
    }

    @Override
    public String inspectSpot(String spotName) {
        List<Discoverer> suitableDiscoverers = discovererRepository.getCollection()
                .stream().filter(d -> d.getEnergy() > 45).collect(Collectors.toList());
        Spot spot = spotsRepository.byName(spotName);

        if (suitableDiscoverers.isEmpty()){
            throw new IllegalArgumentException(SPOT_DISCOVERERS_DOES_NOT_EXISTS);
        }else {
            Operation operation = new OperationImpl();

            operation.startOperation(spot, suitableDiscoverers);
        }
        long tiredDiscoverers = suitableDiscoverers.stream().filter(d -> d.getEnergy() == 0)
                .count();
        spotsCount++;
        return String.format(INSPECT_SPOT, spotName, tiredDiscoverers);
    }

    @Override
    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format(FINAL_SPOT_INSPECT, spotsCount)).append(System.lineSeparator());
        sb.append(FINAL_DISCOVERER_INFO).append(System.lineSeparator());
        for (Discoverer discoverer : discovererRepository.getCollection()) {
            sb.append(String.format(FINAL_DISCOVERER_NAME, discoverer.getName()))
                    .append(System.lineSeparator());
            sb.append(String.format(FINAL_DISCOVERER_ENERGY, discoverer.getEnergy()))
                    .append((System.lineSeparator()));
            if (discoverer.getMuseum().getExhibits().isEmpty()){
                sb.append("Museum exhibits: None").append(System.lineSeparator());
            }else {
                String exhibitsCollection = String.join(", ", discoverer.getMuseum().getExhibits());
                sb.append(String.format(FINAL_DISCOVERER_MUSEUM_EXHIBITS, exhibitsCollection))
                        .append(System.lineSeparator());
            }
        }

        return sb.toString();
    }
}
