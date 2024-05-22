package games.SearchLoggerApplication;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class BST {

    private class BSTNode {
        SearchLog log;
        BSTNode left;
        BSTNode right;

        public BSTNode(SearchLog log) {
            this.log = log;
            this.left = null;
            this.right = null;
        }
    }

    private BSTNode root;

    public void insert(SearchLog log) {
        root = insertRec(root, log);
    }

    private BSTNode insertRec(BSTNode root, SearchLog log) {
        if (root == null) {
            root = new BSTNode(log);
            return root;
        }

        if (log.getTimestamp().isBefore(root.log.getTimestamp())) {
            root.left = insertRec(root.left, log);
        } else if (log.getTimestamp().isAfter(root.log.getTimestamp())) {
            root.right = insertRec(root.right, log);
        }

        return root;
    }

    public void inorder() {
        inorderRec(root);
    }

    private void inorderRec(BSTNode root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.println(root.log);
            inorderRec(root.right);
        }
    }

    public List<SearchLog> rangeQuery(LocalDateTime start, LocalDateTime end) {
        List<SearchLog> result = new ArrayList<>();
        rangeQueryRec(root, start, end, result);
        return result;
    }

    private void rangeQueryRec(BSTNode root, LocalDateTime start, LocalDateTime end, List<SearchLog> result) {
        if (root == null) {
            return;
        }

        if (start.isBefore(root.log.getTimestamp())) {
            rangeQueryRec(root.left, start, end, result);
        }

        if ((start.isEqual(root.log.getTimestamp()) || start.isBefore(root.log.getTimestamp())) &&
                (end.isEqual(root.log.getTimestamp()) || end.isAfter(root.log.getTimestamp()))) {
            result.add(root.log);
        }

        if (end.isAfter(root.log.getTimestamp())) {
            rangeQueryRec(root.right, start, end, result);
        }
    }
}

