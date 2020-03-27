import com.google.inject.AbstractModule;

public class DemoModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(RequestHandler.class).to(ReqresRequestHandler.class);
    }
}
