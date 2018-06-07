package com.horvat.dl.entities;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Lifestyle implements IDisplayable {
    private Boolean vegetarian;
    private Boolean smoker;
    private Boolean consumesAlcoholicBeverage;
    private Boolean usesStimulants;
    private String stimulantsUsed;
    private Double coffeeConsumptionPerDay;
    private Double teaConsumptionPerDay;
    private Double softDrinkConsumptionPerDay;
    private Boolean regularMeals;
    private String predominantEatingOption;

    public Lifestyle(Boolean vegetarian, Boolean smoker, Boolean consumesAlcoholicBeverage, Boolean usesStimulants, String stimulantsUsed, Double coffeeConsumptionPerDay, Double teaConsumptionPerDay, Double softDrinkConsumptionPerDay, Boolean regularMeals, String predominantEatingOption) {
        this.vegetarian = vegetarian;
        this.smoker = smoker;
        this.consumesAlcoholicBeverage = consumesAlcoholicBeverage;
        this.usesStimulants = usesStimulants;
        this.stimulantsUsed = stimulantsUsed;
        this.coffeeConsumptionPerDay = coffeeConsumptionPerDay;
        this.teaConsumptionPerDay = teaConsumptionPerDay;
        this.softDrinkConsumptionPerDay = softDrinkConsumptionPerDay;
        this.regularMeals = regularMeals;
        this.predominantEatingOption = predominantEatingOption;
    }

    public Boolean isvegetarian() {
        return vegetarian;
    }

    public void setvegetarian(Boolean vegetarian) {
        this.vegetarian = vegetarian;
    }

    public Boolean isSmoker() {
        return smoker;
    }

    public void setSmoker(Boolean smoker) {
        this.smoker = smoker;
    }

    public Boolean isConsumesAlcoholicBeverage() {
        return consumesAlcoholicBeverage;
    }

    public void setConsumesAlcoholicBeverage(Boolean consumesAlcoholicBeverage) {
        this.consumesAlcoholicBeverage = consumesAlcoholicBeverage;
    }

    public Boolean isUsesStimulants() {
        return usesStimulants;
    }

    public void setUsesStimulants(Boolean usesStimulants) {
        this.usesStimulants = usesStimulants;
    }

    public String getStimulantsUsed() {
        return stimulantsUsed;
    }

    public void setStimulantsUsed(String stimulantsUsed) {
        this.stimulantsUsed = stimulantsUsed;
    }

    public Double getCoffeeConsumptionPerDay() {
        return coffeeConsumptionPerDay;
    }

    public void setCoffeeConsumptionPerDay(Double coffeeConsumptionPerDay) {
        this.coffeeConsumptionPerDay = coffeeConsumptionPerDay;
    }

    public Double getTeaConsumptionPerDay() {
        return teaConsumptionPerDay;
    }

    public void setTeaConsumptionPerDay(Double teaConsumptionPerDay) {
        this.teaConsumptionPerDay = teaConsumptionPerDay;
    }

    public Double getSoftDrinkConsumptionPerDay() {
        return softDrinkConsumptionPerDay;
    }

    public void setSoftDrinkConsumptionPerDay(Double softDrinkConsumptionPerDay) {
        this.softDrinkConsumptionPerDay = softDrinkConsumptionPerDay;
    }

    public Boolean isRegularMeals() {
        return regularMeals;
    }

    public void setRegularMeals(Boolean regularMeals) {
        this.regularMeals = regularMeals;
    }

    public String getPredominantEatingOption() {
        return predominantEatingOption;
    }

    public void setPredominantEatingOption(String predominantEatingOption) {
        this.predominantEatingOption = predominantEatingOption;
    }

    @Override
    public String toString() {
        return "Lifestyle{" +
                "vegetarian=" + vegetarian +
                ", smoker=" + smoker +
                ", consumesAlcoholicBeverage=" + consumesAlcoholicBeverage +
                ", usesStimulants=" + usesStimulants +
                ", stimulantsUsed='" + stimulantsUsed + '\'' +
                ", coffeeConsumptionPerDay=" + coffeeConsumptionPerDay +
                ", teaConsumptionPerDay=" + teaConsumptionPerDay +
                ", softDrinkConsumptionPerDay=" + softDrinkConsumptionPerDay +
                ", regularMeals=" + regularMeals +
                ", predominantEatingOption='" + predominantEatingOption + '\'' +
                '}';
    }

    @Override
    public Map<String, Map<String, Object>> getDisplayDataGroups() {
        return new HashMap<String, Map<String, Object>>() {{
            put(NON_GROUPED_NAME, new HashMap<String, Object>() {{
                put("Vegetarian", vegetarian);
                put("Smoker", smoker);
                put("Consumes alcoholic beverage", consumesAlcoholicBeverage);
                put("Uses stimulants", usesStimulants);
                put("Stimulants used", stimulantsUsed);
                put("Coffee consumption per day", coffeeConsumptionPerDay);
                put("Tea consumption per day", teaConsumptionPerDay);
                put("Soft drink consumption per day", teaConsumptionPerDay);
                put("Regular meals", regularMeals);
                put("Predominant eating option", predominantEatingOption);
            }});
        }};
    }
}
