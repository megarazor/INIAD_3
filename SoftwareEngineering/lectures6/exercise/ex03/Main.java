public class Main {
    public static void main(String... args){
        System.out.println("Hot pot cooking recipes\n");
        HotPotCooking curry= new HotPotCooking <Beef, CurryPaste> ("Beef curry", new Beef(), new CurryPaste());
        HotPotCooking chickenCreamStew= new HotPotCooking <Chicken, WhiteSauce> ("Chicken cream stew", new Chicken(), new WhiteSauce());
        HotPotCooking nikujaga= new HotPotCooking <Pork, SoySauce> ("Nikujaga", new Pork(), new SoySauce());
        
        System.out.println(curry.getRecipe());
        System.out.println(chickenCreamStew.getRecipe());
        System.out.println(nikujaga.getRecipe());
    }
}
