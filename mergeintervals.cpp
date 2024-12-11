#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

// Function to merge overlapping intervals
vector<pair<int, int>> mergeIntervals(vector<pair<int, int>>& intervals) {
    if (intervals.empty()) return {}; // Return empty result for no intervals

    // Step 1: Sort intervals based on the start times
    sort(intervals.begin(), intervals.end());

    // Step 2: Merge intervals
    vector<pair<int, int>> merged;
    merged.push_back(intervals[0]); // Add the first interval to the merged list

    for (size_t i = 1; i < intervals.size(); ++i) {
        // Get the last interval in the merged list
        auto& last = merged.back();

        // Check for overlap
        if (intervals[i].first <= last.second) {
            // Merge intervals by updating the end time
            last.second = max(last.second, intervals[i].second);
        } else {
            // No overlap, add the current interval to the merged list
            merged.push_back(intervals[i]);
        }
    }

    return merged;
}

int main() {
    // Input intervals
    vector<pair<int, int>> intervals = {
        {1, 3}, {2, 6}, {8, 10}, {15, 18}
    };

    // Merge overlapping intervals
    vector<pair<int, int>> merged = mergeIntervals(intervals);

    // Output the merged intervals
    cout << "Merged Intervals: ";
    for (const auto& interval : merged) {
        cout << "[" << interval.first << ", " << interval.second << "] ";
    }
    cout << endl;

    return 0;
}
