import networkx as nx
# import finalexam

def project_network(G, profit):
    Gp= G.copy()
    n= G.number_of_nodes()
    C= 0
    for p in profit:
        if p > 0:
            C+= p

    for (u, v) in G.edges():
        Gp.edges[(u, v)]['weight']= C + 1
    s= n
    t= n + 1
    Gp.add_nodes_from([s, t])
    for i in range(0, n):
        if profit[i] > 0:
            Gp.add_edge(s, i, weight=profit[i])
        else:
            Gp.add_edge(i, t, weight= -1 * profit[i])
    return Gp


G = nx.read_weighted_edgelist('psp_final.edgelist', create_using=nx.DiGraph(), nodetype=int)
profit = [15, 30, 10, -15, -20, -5]
Gp = project_network(G, profit)
print(Gp.edges(data=True))