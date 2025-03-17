import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.control.Button;
import javafx.geometry.Pos;
import java.util.ArrayList;
public class LinkedList<T extends Comparable<T>> extends GridPane {
    private Node<T> head;
    private Label listLabel;

    public LinkedList() {
        
        Label insertLb = new Label("Insert value:");
        TextField insertTf = new TextField();
        Button insertBtn = new Button("Insert");
        HBox insertBox = new HBox(10, insertLb, insertTf, insertBtn);
        insertBox.setAlignment(Pos.CENTER_LEFT);

        Label deleteLb = new Label("Delete value:");
        TextField deleteTf = new TextField();
        Button deleteBtn = new Button("Delete");
        HBox deleteBox = new HBox(10, deleteLb, deleteTf, deleteBtn);
        deleteBox.setAlignment(Pos.CENTER_LEFT);

        Label searchLb = new Label("Search value:");
        TextField searchTf = new TextField();
        Button searchBtn = new Button("Search");
        Label searchResultLb = new Label();
        HBox searchBox = new HBox(10, searchLb, searchTf, searchBtn, searchResultLb);
        searchBox.setAlignment(Pos.CENTER_LEFT);

        listLabel = new Label("Linked List: [ ]");
        this.add(insertBox, 0, 1);
        this.add(deleteBox, 0, 2);
        this.add(searchBox, 0, 3);
        this.add(listLabel, 0, 4);

        insertBtn.setOnAction(e -> {
            try {
                T value = (T) insertTf.getText();
                insertFirst(value);
                insertTf.clear();
            } catch (Exception ex) {
                listLabel.setText("Invalid input.");
            }
        });

        deleteBtn.setOnAction(e -> {
            try {
                T value = (T) deleteTf.getText();
                delete(value);
                deleteTf.clear();
            } catch (Exception ex) {
                listLabel.setText("Invalid input.");
            }
        });

        searchBtn.setOnAction(e -> {
            try {
                T value = (T) searchTf.getText();
                boolean found = search(value);
                if (found) {
                    searchResultLb.setText("Found");
                } else {
                    searchResultLb.setText("Not Found");
                }
            } catch (Exception ex) {
                searchResultLb.setText("Invalid input.");
            }
        });
    }

    public void insertFirst(T data) {
        Node<T> node = new Node<>(data);
        node.next = head;
        head = node;
        listLabel.setText(toString()); 
    }

    public boolean search(T target) {
        Node<T> curr = head;
        while (curr != null) {
            if (curr.data.compareTo(target) == 0) {
                return true;
            }
            curr = curr.next;
        }
        return false;
    }

    public void delete(T data) {
        if (head == null) return;

        if (head.data.equals(data)) {
            head = head.next;
        } else {
            Node<T> current = head;
            while (current.next != null && !current.next.data.equals(data)) {
                current = current.next;
            }
            if (current.next != null) {
                current.next = current.next.next;
            }
        }
        listLabel.setText(toString()); 
    }

    public String toString() {
        String s = "Head --> ";
        Node<T> curr = head;
        while (curr != null) {
            s += curr.data + " --> ";
            curr = curr.next;
        }
        return s + "Null";
    }
}
