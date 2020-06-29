public class Ingrediente{
  private String nombre;
  private float cantidad;
  private float precio;
  private String medida;

  public Ingrediente(String nombre, float cantidad, float precio, String medida){
    this.nombre = nombre;
    this.cantidad = cantidad;
    this.precio = precio;
    this.medida = medida;
  }

  public String GetNombre(){
    return nombre;
  }

  public float GetCantidad(){
    return cantidad;
  }

  public float GetPrecio(){
    return precio;
  }

  public String GetMedida(){
    return medida;
  }

  public void SetNombre(String nombre){
    this.nombre = nombre;
  }

  public void SetCantidad(float cantidad){
    this.cantidad = cantidad;
  }

  public void SetPrecio(float precio){
    this.precio = precio;
  }

  public void SetMedida(String medida){
    this.medida = medida;
  }

  
}