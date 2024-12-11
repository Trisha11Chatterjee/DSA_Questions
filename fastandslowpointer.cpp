#include <iostream>
using namespace std;

// Definition for singly-linked list node
struct ListNode {
    int val;
    ListNode* next;
    ListNode(int x) : val(x), next(NULL) {}
};

// Function to detect a cycle in the linked list
bool hasCycle(ListNode* head) {
    if (!head || !head->next) return false; // Base case: No cycle if list is empty or has only one node

    ListNode* slow = head;      // Slow pointer moves 1 step at a time
    ListNode* fast = head;      // Fast pointer moves 2 steps at a time

    while (fast && fast->next) {
        slow = slow->next;      // Move slow pointer
        fast = fast->next->next; // Move fast pointer

        if (slow == fast) {     // Cycle detected
            return true;
        }
    }

    return false; // No cycle
}

int main() {
    // Create a sample linked list
    ListNode* head = new ListNode(1);
    head->next = new ListNode(2);
    head->next->next = new ListNode(3);
    head->next->next->next = new ListNode(4);
    head->next->next->next->next = head->next; // Create a cycle

    if (hasCycle(head)) {
        cout << "Cycle detected in the linked list." << endl;
    } else {
        cout << "No cycle detected in the linked list." << endl;
    }

    // Cleanup to avoid memory leak (if no cycle)
    if (!hasCycle(head)) {
        ListNode* temp = head;
        while (temp) {
            ListNode* nextNode = temp->next;
            delete temp;
            temp = nextNode;
        }
    }

    return 0;
}
