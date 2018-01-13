package emufog.application;

import emufog.container.Docker;
import emufog.topology.Types.ApplicationType;

/**
 * Application object defining container, mounts, scripts.
 */
public class Application {

    private String name;

    private String type;

    private ApplicationType applicationType;

    Docker container = new Docker();

    /**
     * Set corresponding application image.
     * @param img
     */
    public void image(String img, String imageVersion){
        container.image(img);
        container.imageVersion(imageVersion);
    }

    public void resources(int memoryLimit, float cpuShare){
        container.memoryLimit(memoryLimit);
        container.cpuShare(cpuShare);
    }

    public void setName(String name) {
        this.name = name;
        container.setContainerName(name);
    }

    public void type(String type) {
        this.type = type;
    }

    public void containerSettings(){

    }

    public void setApplicationType(ApplicationType applicationType) {
        this.applicationType = applicationType;
    }

    public ApplicationType getApplicationType() {
        return applicationType;
    }
}
