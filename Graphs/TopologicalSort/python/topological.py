from collections import defaultdict

def def_value():
  return "No Value Found"

adjacency_list = defaultdict(def_value)
adjacency_list["COMP1223"] = ['COMP1231']
adjacency_list["COMP1231"] = ['COMP1230']
adjacency_list["COMP1202"] = ['COMP2129']
adjacency_list["COMP1230"] = ['COMP2139']
adjacency_list["COMP2129"] = ['COMP2139']
adjacency_list["COMP2139"] = ['COMP3123']
adjacency_list["COMP3123"] = []


visited = defaultdict(def_value)
visited["COMP1223"] = False
visited["COMP1231"] = False
visited["COMP1202"] = False
visited["COMP1230"] = False
visited["COMP2129"] = False
visited["COMP2139"] = False
visited["COMP3123"] = []


stack = []

def topological_sort(vertex):
  if not visited[vertex]:
    visited[vertex] = True
    for neighbor in adjacency_list[vertex]:
      topological_sort(neighbor)
    stack.insert(0, vertex)

def solve(adjacency_list):
  for node in adjacency_list:
    topological_sort(node)

solve(adjacency_list)

print("\n\n")
print("=== The order to finish ===")
for cout, stack in enumerate(visited):
  print(f"{cout+1}: {stack}")