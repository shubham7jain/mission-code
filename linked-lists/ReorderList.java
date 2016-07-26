/*
Given a singly linked list

    L: L0 → L1 → … → Ln-1 → Ln,
reorder it to:

    L0 → Ln → L1 → Ln-1 → L2 → Ln-2 → …
You must do this in-place without altering the nodes’ values.

For example,
Given {1,2,3,4}, reorder it to {1,4,2,3}.

*/
/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 * 
 * typedef struct ListNode listnode;
 * 
 * listnode* listnode_new(int val) {
 *     listnode* node = (listnode *) malloc(sizeof(listnode));
 *     node->val = val;
 *     node->next = NULL;
 *     return node;
 * }
 */
/**
 * @input A : Head pointer of linked list 
 * 
 * @Output head pointer of list.
 */
listnode* reorderList(listnode* A) {
    listnode* head = A;
    //Get the length of List
    int length = 0;
    while(A!=NULL) {
        length++;
        A = A->next;
    }
    if(length <=2)
        return head;
    int startRight;
    if(length%2==0)
        startRight = length - length/2 + 2;
    else
        startRight = length - length/2 + 1;
    int i=1;
    A = head;
    listnode* last = NULL;
    while(i<startRight) {
        last = A;
        A = A->next;
        i++;
    }
    
    listnode* right = A;
    listnode *rightList[length-startRight + 1];
    i = 0;
    while(right!=NULL) {
        rightList[i] = right;
        i++;
        right = right->next;
    }
    
    int j = i-1;
    i=0;
    A = head;
    while(j>=0 && A!=NULL) {
        listnode* temp = A->next;
        A->next = rightList[j--];
        A->next->next = temp;
        A = A->next->next;
    }
    last->next=NULL;
    return head;
}
