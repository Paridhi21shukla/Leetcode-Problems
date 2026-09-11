class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        findPaths(root, "", result);

        return result;
    }

    private void findPaths(TreeNode node, String path, List<String> result) {
        if (node == null) {
            return;
        }

        // Current node ko path mein add karo
        if (path.equals("")) {
            path = "" + node.val;
        } else {
            path = path + "->" + node.val;
        }

        // Agar leaf node hai
        if (node.left == null && node.right == null) {
            result.add(path);
            return;
        }

        // Left subtree
        findPaths(node.left, path, result);

        // Right subtree
        findPaths(node.right, path, result);
    }
}