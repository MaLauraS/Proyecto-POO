import java.util.ArrayList;
import java.util.List;

public class Platillo{
  
    private int typeDish;
    private String name;
    private String preparacion;
    List<Ingrediente> ingredientes = new ArrayList<Ingrediente>();
    List<Float> cantidad = new ArrayList<Float>();
    private float precio;
    
    public Platillo(int typeDish, String name, String preparacion, List<Ingrediente> ingredientes, List<Float> cantidad){
      this.typeDish = typeDish;
      this.name = name;
      this.preparacion = preparacion;
      this.ingredientes = ingredientes;
      this.cantidad = cantidad;
      CalcularPrecio(ingredientes, cantidad);
    }

    private void CalcularPrecio(List<Ingrediente> i, List<Float> c){
      float sumatoria = 0;
      for(int indice = 0;indice<i.size();indice++)
      {
        sumatoria = sumatoria + (i.get(indice).GetPrecio() * c.get(indice));
      }
      precio = sumatoria;
    }

    public int GetTypeDish(){
      return typeDish;
    }

    public String GetName(){
      return name;
    }

    public String GetPreparacion(){
      return preparacion;
    }

    public List<Ingrediente> GetIngredientes(){
      return ingredientes;
    }

    public List<Float> GetCantidades(){
      return cantidad;
    }

    public float GetPrecio(){
      return precio;
    }

    public void SetTypeDish(int typeDish){
      this.typeDish = typeDish;
    }

    public void SetName(String name){
      this.name = name;
    }

    public void SetPreparacion(String preparacion){
      this.preparacion = preparacion;
    }

    public void SetIngredientes(List<Ingrediente> ingredientes){
      this.ingredientes = ingredientes;
    }

    public void SetCantidades(List<Float> cantidad){
      this.cantidad = cantidad;
    }


}