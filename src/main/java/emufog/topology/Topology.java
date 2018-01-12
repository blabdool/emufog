package emufog.topology;

import com.google.common.graph.MutableNetwork;
import emufog.reader.BriteReader;
import emufog.reader.TopologyReader;
import emufog.settings.Settings;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Set;

public class Topology {

    private MutableNetwork<Node,Link> topology;

    private static TopologyReader reader;

    private Settings settings;

    private void addNode(Node node){
        topology.addNode(node);
    }

    private void removeNode(Node node) {topology.removeNode(node);}

    private void addLink(Node nodeU, Node nodeV, Link link){
        topology.addEdge(nodeU,nodeV,link);
    }

    private void removeLink(Link link){ topology.removeEdge(link);}

    private void addFogNode(FogNode fogNode){
        topology.addNode(fogNode);
    }

    private void addDeviceNode(Device device){
        topology.addNode(device);
    }

    private void addRouter(Router router){
        topology.addNode(router);
    }

    public Set<Node> nodes(){ return topology.nodes(); }

    public Set<Link> links(){
        return topology.edges();
    }

    private Topology(TopologyBuilder builder) throws IOException {

        this.settings = builder.settings;

        read();
        identifyEdge();
        placeFogNodes();
        assignApplications();

    }

    private void read() throws IOException {
        reader = new BriteReader();

        this.topology = reader.parse(settings.getInputGraphFilePath());

    }

    private void identifyEdge(){}

    private void placeFogNodes(){}

    private void assignApplications(){}



    public static class TopologyBuilder{

        private Settings settings;

        public Topology build() throws IOException {
            return new Topology(this);
        }

        public TopologyBuilder setup(Settings settings){
            this.settings = settings;
            return this;
        }

    }

    public void export(){

        Path exportPath = settings.getExportFilePath();


    }

    private MutableNetwork<Node, Link> getTopology() {
        return topology;
    }
}