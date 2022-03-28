package Control;

import Model.BinaryTree;
import View.DrawingPanel;
import View.TreeView.TreeNode;
import View.TreeView.TreePath;

/**
 * Created by Jean-Pierre on 12.01.2017.
 */
public class MainController {

    private BinaryTree<String> binaryTree;

    public MainController(){
        binaryTree = new BinaryTree<>(""); // Ein Baum ohne Wurzel-Inhalt ist auf dauer ein leerer Baum - es lassen sich laut Dokumentation nichtmal Bäume anhängen. Also wird die Wurzel gefüllt.
        createMorseTree();
    }

    /**
     * Zur Präsentation des Programms wird der Morsecode im Baum dargestellt.
     */
    private void createMorseTree(){
        //TODO 02: Vervollständige den Morsebaum. Such bei google nach "morsecode as tree" als Vorlage. Das hilft, die Übersicht zu wahren.
        BinaryTree<String> e = new BinaryTree<>("E");
        BinaryTree<String> t = new BinaryTree<>("T");
        binaryTree.setLeftTree(e);
        binaryTree.setRightTree(t);

        BinaryTree<String> i = new BinaryTree<>("I");
        BinaryTree<String> a = new BinaryTree<>("A");
        e.setLeftTree(i);
        e.setRightTree(a);

        BinaryTree<String> s = new BinaryTree<>("S");
        BinaryTree<String> u = new BinaryTree<>("U");
        i.setLeftTree(s);
        i.setRightTree(u);

        BinaryTree<String> h = new BinaryTree<>("H");
        BinaryTree<String> v = new BinaryTree<>("V");
        s.setLeftTree(h);
        s.setRightTree(v);

        BinaryTree<String> f = new BinaryTree<>("F");
        u.setLeftTree(f);

        BinaryTree<String> r = new BinaryTree<>("R");
        BinaryTree<String> w = new BinaryTree<>("W");
        a.setLeftTree(r);
        a.setRightTree(w);

        BinaryTree<String> l = new BinaryTree<>("L");
        r.setLeftTree(l);

        BinaryTree<String> p = new BinaryTree<>("P");
        BinaryTree<String> j = new BinaryTree<>("J");
        w.setLeftTree(p);
        w.setRightTree(j);

        //Rechte Seite
        BinaryTree<String> n = new BinaryTree<>("N");
        BinaryTree<String> m = new BinaryTree<>("M");
        t.setLeftTree(n);
        t.setRightTree(m);

        BinaryTree<String> d = new BinaryTree<>("D");
        BinaryTree<String> k = new BinaryTree<>("K");
        n.setLeftTree(d);
        n.setRightTree(k);

        BinaryTree<String> b = new BinaryTree<>("B");
        BinaryTree<String> x = new BinaryTree<>("X");
        d.setLeftTree(b);
        d.setRightTree(x);

        BinaryTree<String> c = new BinaryTree<>("C");
        BinaryTree<String> y = new BinaryTree<>("Y");
        k.setLeftTree(c);
        k.setRightTree(y);

        BinaryTree<String> g = new BinaryTree<>("G");
        BinaryTree<String> o = new BinaryTree<>("O");
        m.setLeftTree(g);
        m.setRightTree(o);

        BinaryTree<String> z = new BinaryTree<>("Z");
        BinaryTree<String> q = new BinaryTree<>("Q");
        g.setLeftTree(z);
        g.setRightTree(q);
    }

    /**
     * Der Baum wird im übergebenem Panel dargestellt.
     * Dazu wird zunächst die alte Zeichnung entfernt.
     * Im Anschluss wird eine eine internete Hilfsmethode aufgerufen.
     * @param panel Das DrawingPanel-Objekt, auf dem gezeichnet wird.
     */
    public void showTree(DrawingPanel panel){
        panel.removeAllObjects();
        //Der Baum wird in der Mitte des Panels beginnend gezeichnet: x = panel.getWidth()/2
        //Der linke und rechte Knoten in Tiefe 1 sind jeweils ein Viertel der Breite des Panels entfernt: spaceToTheSide = panel.getWidth()/4
        showTree(binaryTree, panel, panel.getWidth()/2, 50, panel.getWidth()/4);
		
	//Aufruf fordert das Panel zur Aktualisierung auf.
	panel.repaint();
    }

    /**
     * Hilfsmethode zum Zeichnen des Baums.
     * Für jeden Knoten wird ein neues TreeNode-Objekt dem panel hinzugefügt.
     * Für jede Kante wird ein neues TreePath-Pbjekt dem panel hinzugefügt.
     * @param tree Der zu zeichnende (Teil)Binärbaum.
     * @param panel Das DrawingPanel-Objekt, auf dem gezeichnet wird.
     * @param startX x-Koordinate seiner Wurzel
     * @param startY y-Koordinate seiner Wurzel
     * @param spaceToTheSide Gibt an, wie weit horizontal entfernt die folgenden Bäume gezeichnet werden soll.
     */
    private void showTree(BinaryTree tree, DrawingPanel panel, double startX, double startY, double spaceToTheSide) {
        //TODO 03: Vervollständige diese Methode. Aktuell wird nur der Wurzelknoten gezeichnet.
        if (!tree.isEmpty()) {
            TreeNode node = new TreeNode(startX, startY, 10, tree.getContent().toString(), false);
            panel.addObject(node);

            if(!tree.getLeftTree().isEmpty()){
              panel.addObject(new TreePath(startX, startY,startX- spaceToTheSide, startY+70,5,true));
              showTree(tree.getLeftTree(), panel, startX -spaceToTheSide,startY+65, spaceToTheSide/2);
            }
            if(!tree.getRightTree().isEmpty()) {
                panel.addObject(new TreePath(startX, startY,startX+ spaceToTheSide, startY+70,5,true));
                showTree(tree.getRightTree(), panel, startX + spaceToTheSide, startY + 65, spaceToTheSide / 2);
            }
        }
    }

    /**
     * Es wird das Ergebnis einer Traversierung bestimmt.
     * Ruft dazu eine interne Hilfsmethode auf.
     * @return Das Ergebnis der Traversierung als Zeichenkette.
     */
    public String traverse(){
        return traverse(binaryTree);
    }

    /**
     * Interne hilfsmethode zur Traversierung.
     * @param tree Der zu traversierende Binärbaum.
     * @return Das Ergebnis der Traversierung als Zeichenkette.
     */
    private String traverse(BinaryTree tree){
        //TODO 04: Nachdem wir geklärt haben, was eine Traversierung ist, muss diese Methode noch vervollständigt werden. Sollte ein Kinderspiel sein.

        if (!tree.getLeftTree().isEmpty()) {
            return tree.getLeftTree().getContent() + "" + traverse(tree.getLeftTree());
        }
        if (!tree.getRightTree().isEmpty()) {
            return tree.getRightTree().getContent() + "" + traverse(tree.getRightTree());
        }
        return "-"+ "End";
    }
	
    /**
     * Interne Übungsmethode zur Traversierung.
     * @param tree Der zu traversierende Binärbaum.
     * @return Die Anzahl der Knoten in diesem Baum
     */
    private int countNodes(BinaryTree tree){
        //TODO 05: Übungsmethode
	return 0;
    }
}
