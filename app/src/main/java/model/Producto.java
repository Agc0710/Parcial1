package model;

public class Producto implements Comparable {
    private String Nombre;
    private int Codigo;
    private int Valor;
    private boolean IVA;
    private String Descripcion;

    public Producto(){

    }
    public Producto(String nombre, int codigo, int valor, boolean iva, String descripcion) {
        Nombre = nombre;
        Codigo = codigo;
        Valor = valor;
        IVA = iva;
        Descripcion = descripcion;
    }
    public String getNombre()
    {
        return Nombre;
    }

    public void setNombre(String nombre)
    {
        Nombre = nombre;
    }
    public int getCodigo()
    {
        return Codigo;
    }

    public void setCodigo(int codigo)

    {
        Codigo = codigo;
    }
    public int getValor()
    {
        return Valor;
    }

    public void setValor(int valor)
    {
        Valor = valor;
    }
    public boolean getIVA()
    {
        return IVA;
    }
    public void setIVA(boolean iva)
    {
        IVA = iva;
    }
    public String getDescripcion()
    {
        return Descripcion;
    }

    public void setDescripcion(String descripcion)
    {
        Descripcion = descripcion;
    }


   @Override
    public int compareTo(Object o) {
        double compareage=((Producto)o).getValor();
        /* ASCENDENTE*/
        return (int) (this.Valor-compareage);
    }

}
