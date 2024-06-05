import java.util.ArrayList;
import java.util.List;

class Food {     // Memento is Food
   private String Name;  // state is food

   public Food(String name) {
      this.Name = name;
   }

   public String getname() {
      return Name;
   }
}

class FoodStall{  // FoodStall is originator
   private String name;

   public void setname(String name){
      this.name = name;
   }

   public String getname(){
      return name;
   }

   public Food savenameToFood(){
      return new Food(name);
   }

   public void getnameFromFood(Food food){
      name = food.getname();
   }
}

class FoodCounter {  // FoodCounter is foodcounter
   private List<Food> FoodList = new ArrayList<Food>();

   public void add(Food name){
      FoodList.add(name);
   }

   public Food get(int index){
      return FoodList.get(index);
   }
}

public class FoodMemento {
   public static void main(String[] args) {
   
      FoodStall foodstall = new FoodStall();
      FoodCounter foodcounter = new FoodCounter();
      
      foodstall.setname("Burger");
      foodstall.setname("Pizza");
      foodcounter.add(foodstall.savenameToFood());
      
      foodstall.setname("Sandwich");
      foodcounter.add(foodstall.savenameToFood());
      
      foodstall.setname("Mocktails");
      System.out.println("Current counter name: " + foodstall.getname());		
      
      foodstall.getnameFromFood(foodcounter.get(0));
      System.out.println("First counter name: " + foodstall.getname());
      foodstall.getnameFromFood(foodcounter.get(1));
      System.out.println("Second counter name: " + foodstall.getname());
   }
}