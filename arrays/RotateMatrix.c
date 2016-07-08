/*
You are given an n x n 2D matrix representing an image.

Rotate the image by 90 degrees (clockwise).

You need to do this in place.
*/
void rotate(int** A, int n11, int n12) {
    int layer, i;
    for(layer = 0; layer < n11/2; layer++) {
        int first = layer;
        int last = n11-1-layer;
        for(i = first;i < last; i++) {
            int temp = A[first][i];
            A[first][i] = A[last - i + first][first];
            A[last - i + first][first] = A[last][last - i + first];
            A[last][last - i + first] = A[i][last];
            A[i][last] = temp;
        }
    }
}