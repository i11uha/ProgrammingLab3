import enums.NativeLanguage;
import enums.Mood;
import enums.Nationality;
import events.Voyage;
import exceptions.InvalidTradeException;
import objects.*;
import persons.Narrator;
import persons.Neighbour;
import persons.Voyager;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Random rand = new Random();
        try {
            // я использовал random, чтобы показать изменения состояния обьектов
            double myTotalArea = 80 + rand.nextInt(41); // 80–120
            double neighborTotalArea = 80 + rand.nextInt(41);
            // каждый из плантаторов получает случайное количество гектар земли
            Plantation myPlantation = new Plantation("Brazil", myTotalArea);

            Plantation neighborPlantation = new Plantation("Brazil",neighborTotalArea);

            // Раскоментируй для демонтсрации OverloadException
//            Plantation smallPlantation = new Plantation("Brazil",2.0);
//            smallPlantation.plantProduct(new Tobacco(), 10.0);

            // убери комментирование для демонстрациии NoHarvestException

//            Plantation badPlantation = new Plantation("Brazil",0);
//            Narrator badNarrator = new Narrator();
//            badNarrator.setCurrentPlantation(badPlantation);
//            badNarrator.setMood(Mood.values()[rand.nextInt(Mood.values().length)]);
//            badNarrator.work();

            // также количество засаженных урожаем территорий
            double tobaccoShare = rand.nextDouble();
            myPlantation.setTobaccoSquare(myTotalArea * tobaccoShare);
            myPlantation.setSugarCaneSquare(myTotalArea * (1 - tobaccoShare));


            double sugarShare = rand.nextDouble();
            neighborPlantation.setSugarCaneSquare(neighborTotalArea * sugarShare);
            neighborPlantation.setTobaccoSquare(neighborTotalArea * (1 - sugarShare));

            // Персонажи
            Narrator narrator = new Narrator();
            narrator.setName("Robinson (as Narrator)");
            narrator.setNationality(Nationality.ENGLISH);
            narrator.setMood(Mood.values()[rand.nextInt(Mood.values().length)]);
            narrator.setWorkingCapital(150);
            narrator.setCurrentPlantation(myPlantation);
            myPlantation.setOwner(narrator);

            ArrayList<ProductsTrade> narratorInventory = new ArrayList<>();
            narratorInventory.add(new ProductsTrade("Семена табака", 20, 1.5));
            narratorInventory.add(new ProductsTrade("Инструменты", 5, 10.0));
            narrator.setInventory(narratorInventory);

            Neighbour neighbour = new Neighbour();
            neighbour.setName("Manuel");
            neighbour.setNationality(Nationality.PORTUGUESE);
            neighbour.setMood(Mood.values()[rand.nextInt(Mood.values().length)]);
            neighbour.setWorkingCapital(140);
            neighbour.setCurrentPlantation(neighborPlantation);
            neighborPlantation.setOwner(neighbour);
            neighbour.work();
            ArrayList<ProductsTrade> neighbourInventory = new ArrayList<>();
            neighbourInventory.add(new ProductsTrade("Семена тростника", 25, 1.2));
            neighbour.setInventory(neighbourInventory);


            System.out.println("\n" + narrator.getName() + " использует семена для посадки...");
            ArrayList<ProductsTrade> usedSeeds = new ArrayList<>();
            usedSeeds.add(new ProductsTrade("Семена табака", 20, 1.5));
            narrator.removeInventory(usedSeeds);
            narrator.work();

            Plantation currentPlot = narrator.getCurrentPlantation();
            if (currentPlot != null) {
                System.out.println(narrator.getName() + " управляет плантацией в " +
                        currentPlot.getLocation() + " общей площадью " +
                        String.format("%.1f", currentPlot.getSquare()) + " га");
            }
            // выводим информацию о владениях
            System.out.printf("%s (%s):\n", narrator.getName(), narrator.getMood());
            System.out.printf("  Общая площадь: %.1f\n", myTotalArea);
            System.out.printf("  Под табаком: %.1f\n", myPlantation.getTobaccoSquare());
            System.out.printf("  Под тростником: %.1f\n\n", myPlantation.getSugarCaneSquare());

            System.out.printf("%s (%s):\n", neighbour.getName(), neighbour.getMood());
            System.out.printf("  Общая площадь: %.1f\n", neighborTotalArea);
            System.out.printf("  Под табаком: %.1f\n", neighborPlantation.getTobaccoSquare());
            System.out.printf("  Под тростником: %.1f\n\n", neighborPlantation.getSugarCaneSquare());

            narrator.speak("давай обменяемся семенами — мне нужны твои побеги тростника");
            neighbour.speak("с радостью, робинзон");

            // Торговля плантаций
            System.out.println("Торгует плантация " + narrator.getName() +
                    " и плантация " + neighbour.getName() + ".");
            myPlantation.tradeWith(neighborPlantation);
            myPlantation.expandArea(10.0);
            narrator.dream("<...> богатой приключениями жизни, о которой я мечтал...");
//            убери комментарий для  того чтобы продемонстрироват работу исключения: "InvalidTradeException"
//            myPlantation.tradeWith(null);

            System.out.println("Остаток инвентаря у " + narrator.getName() + ":");
            for (ProductsTrade item : narrator.getInventory()) {
                System.out.println("  - " + item.name() + ": " + item.count() + " шт.");
            }

            System.out.println(narrator.getName() + " — гражданин " + narrator.getNationality());

            // Narrator изучает португалльский для торговли
            // используется паттерн Builder
            CourseBuilder courseBuilder = new CourseBuilder();
            Director director = new Director();
            director.makePortugueseCourse(courseBuilder);
            narrator.study(courseBuilder.getResult()); // теперь знает португальский

            // экспорт
            ProductsTrade tobaccoExport = myPlantation.prepareForExport();
            System.out.println("\nЭКСПОРТ ТАБАКА");
            System.out.println("Экспортирует: " + narrator.getName());
            System.out.println("Тюков табака: " + tobaccoExport.count());
            System.out.println("Базовая цена за тюк: $" + String.format("%.2f", tobaccoExport.cost()));

            // подготовка к экпедиции
            Ship ship = new Ship();
            ship.setName("Fortuna");
            ship.setCapacity(100);
            ship.setCurrentDestination(NativeLanguage.LISBON); // порт Лиссабон

            Voyage voyage = new Voyage();
            voyage.setShip(ship);
            voyage.setDestination(NativeLanguage.LISBON);


            Voyager voyager = new Voyager();
            voyager.setName("Robinson (as Trader)");
            voyager.setNationality(Nationality.ENGLISH);
            voyager.setMood(Mood.AMBITIOUS);
            voyager.setCurrentVoyage(voyage);

            Voyage assignedVoyage = voyager.getCurrentVoyage();
            if (assignedVoyage != null) {
                System.out.println(voyager.getName() + " назначен на рейс в " +
                        assignedVoyage.getDestination() + " на корабле \"" +
                        assignedVoyage.getShip().getName() + "\"");
            }

            // если знает язык порта — +20% к цене
            boolean knowsLocalLanguage = false;
            if (ship.getCurrentDestination() == NativeLanguage.LISBON) {
                knowsLocalLanguage = narrator.knowsLanguage(Nationality.PORTUGUESE);
            }

            ProductsTrade finalDeal = voyager.adjustPriceByMood(tobaccoExport, knowsLocalLanguage); // если знает язык то он полуучит больше выручки

            // загрузка и отправление
            ArrayList<ProductsTrade> cargo = new ArrayList<>();
            cargo.add(finalDeal);
            voyage.sail(cargo);

            int profit = (int) finalDeal.sell();
            int newCapital = narrator.getWorkingCapital() + profit; //  getWorkingCapital
            narrator.setWorkingCapital(newCapital);

            // финалььная сделка в порту
            System.out.println("\nПРОДАЖА В ПОРТУ");
            System.out.println("Порт: " + ship.getCurrentDestination());
            if (knowsLocalLanguage) {
                System.out.println("Торговец знает местный язык — удалось договориться о лучшей цене!");
            } else {
                System.out.println("Язык неизвестен — цена ниже рыночной.");
            }
            System.out.println("Финальная цена за тюк: $" + String.format("%.2f", finalDeal.cost()));
            System.out.println("Общий доход от продажи " + finalDeal.count() + " тюков: $" +
                    String.format("%.2f", finalDeal.sell()));

        } catch (InvalidTradeException e) {
            System.err.println("Ошибка торговли: " + e.getMessage());
        } catch (IllegalStateException e) {
            System.err.println("Ошибка состояния: " + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}