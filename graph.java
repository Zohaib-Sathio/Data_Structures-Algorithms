package data.structures;

public class graph {

    int size;
    String[] vertices;
    boolean[][] a;

    graph(String[] args) {
        size = args.length;
        vertices = new String[size];
        System.arraycopy(args, 0, vertices, 0, size);
        a = new boolean[size][size];
    }

    public void add(String v, String w) {
        int i = index(v);
        int j = index(w);
        a[i][j] = a[j][i] = true;
    }

    private int index(String vertex) {
        for (int i = 0; i < size; i++)
            if (vertex.equals(vertices[i]))
                return i;
        throw new IllegalArgumentException("Wrong values to be added.");
    }

    @Override
    public String toString() {
        if (size == 0) return "";
        StringBuffer buff = new StringBuffer("{ " + vertex(0));
        for (int i = 1; i < size; i++)
            buff.append(", ").append(vertex(i));
        return buff + " }";

    }

    private String vertex(int i) {
        StringBuffer buff = new StringBuffer(vertices[i] + ":");
        for (int j = 0; j < size; j++)
            if (a[i][j])
                buff.append(vertices[j]);
        return buff + "";
    }

    public static void main(String[] args) {
        String[] a = {"A", "B", "C", "D"};
        graph myGraph = new graph(a);
        myGraph.add("A", "B");
        myGraph.add("A", "D");
        myGraph.add("B", "C");
        myGraph.add("B", "D");
        myGraph.add("C", "D");
        System.out.println(myGraph.toString());

    }

}
