package parser;
import guru.nidi.graphviz.attribute.Color;
import guru.nidi.graphviz.attribute.Label;
import guru.nidi.graphviz.attribute.Rank;
import guru.nidi.graphviz.attribute.Style;
import guru.nidi.graphviz.engine.Format;
import guru.nidi.graphviz.engine.Graphviz;
import guru.nidi.graphviz.model.Graph;
import guru.nidi.graphviz.model.MutableGraph;
import guru.nidi.graphviz.model.MutableNode;
import guru.nidi.graphviz.model.Node;

import java.io.File;
import java.io.IOException;

import static guru.nidi.graphviz.attribute.Rank.RankDir.LEFT_TO_RIGHT;
import static guru.nidi.graphviz.attribute.Rank.RankDir.TOP_TO_BOTTOM;
import static guru.nidi.graphviz.model.Factory.*;
public class A {
    public static void main(String[] args) {
        MutableNode a1 = mutNode("a1").add(Label.html("a"));
        MutableNode a2 = mutNode("a2").add(Label.html("a"));

        MutableGraph g = mutGraph("example1").setDirected(true).add(
               a1.addLink(mutNode("b")));
        g.add(a2.addLink(mutNode("c")));
        g.add(a1.addLink(mutNode("a7")));
        try {
            Graphviz.fromGraph(g).width(200).height(300).render(Format.PNG).toFile(new File("example/ex1.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void drawTree() {

    }
}
