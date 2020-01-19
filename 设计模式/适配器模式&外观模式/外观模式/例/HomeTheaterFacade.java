/**
 * @autor hecaigui
 * @date 2020-1-12
 * @description
 */
public class HomeTheaterFacade {
    CdPlayer cd;
    Screen screen;
    TeaterLights lights;
    public HomeTheaterFacade (CdPlayer cd,Screen screen,TeaterLights lights){
        this.cd = cd;
        this.screen = screen;
        this.lights = lights;
    }
    //外观方法
    public void watchMovie(String movie){
        cd.on();
        cd.set(movie);
        screen.on();
        lights.close();
    }
    public void endMovie(){
        cd.close();
        screen.close();
        lights.on();
    }
}
