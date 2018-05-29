package com.horvat.dal.entities;

public class Lifestyle {
    private boolean vegeterian;
    private boolean smoker;
    private boolean consumesAlcoholicBeverage;
    private boolean usesStimulants;
    private String stimulantsUsed;
    private double coffeeConsumptionPerDay;
    private double teaConsumptionPerDay;
    private double softDrinkConsumptionPerDay;
    private boolean regularMeals;
    private String predominantEatingOption;

    public Lifestyle(boolean vegeterian, boolean smoker, boolean consumesAlcoholicBeverage, boolean usesStimulants, String stimulantsUsed, double coffeeConsumptionPerDay, double teaConsumptionPerDay, double softDrinkConsumptionPerDay, boolean regularMeals, String predominantEatingOption) {
        this.vegeterian = vegeterian;
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

    public boolean isVegeterian() {
        return vegeterian;
    }

    public void setVegeterian(boolean vegeterian) {
        this.vegeterian = vegeterian;
    }

    public boolean isSmoker() {
        return smoker;
    }

    public void setSmoker(boolean smoker) {
        this.smoker = smoker;
    }

    public boolean isConsumesAlcoholicBeverage() {
        return consumesAlcoholicBeverage;
    }

    public void setConsumesAlcoholicBeverage(boolean consumesAlcoholicBeverage) {
        this.consumesAlcoholicBeverage = consumesAlcoholicBeverage;
    }

    public boolean isUsesStimulants() {
        return usesStimulants;
    }

    public void setUsesStimulants(boolean usesStimulants) {
        this.usesStimulants = usesStimulants;
    }

    public String getStimulantsUsed() {
        return stimulantsUsed;
    }

    public void setStimulantsUsed(String stimulantsUsed) {
        this.stimulantsUsed = stimulantsUsed;
    }

    public double getCoffeeConsumptionPerDay() {
        return coffeeConsumptionPerDay;
    }

    public void setCoffeeConsumptionPerDay(double coffeeConsumptionPerDay) {
        this.coffeeConsumptionPerDay = coffeeConsumptionPerDay;
    }

    public double getTeaConsumptionPerDay() {
        return teaConsumptionPerDay;
    }

    public void setTeaConsumptionPerDay(double teaConsumptionPerDay) {
        this.teaConsumptionPerDay = teaConsumptionPerDay;
    }

    public double getSoftDrinkConsumptionPerDay() {
        return softDrinkConsumptionPerDay;
    }

    public void setSoftDrinkConsumptionPerDay(double softDrinkConsumptionPerDay) {
        this.softDrinkConsumptionPerDay = softDrinkConsumptionPerDay;
    }

    public boolean isRegularMeals() {
        return regularMeals;
    }

    public void setRegularMeals(boolean regularMeals) {
        this.regularMeals = regularMeals;
    }

    public String getPredominantEatingOption() {
        return predominantEatingOption;
    }

    public void setPredominantEatingOption(String predominantEatingOption) {
        this.predominantEatingOption = predominantEatingOption;
    }
}
