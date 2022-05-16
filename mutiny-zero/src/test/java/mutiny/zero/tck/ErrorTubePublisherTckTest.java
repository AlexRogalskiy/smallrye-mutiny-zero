package mutiny.zero.tck;

import org.reactivestreams.Publisher;
import org.reactivestreams.tck.PublisherVerification;
import org.reactivestreams.tck.TestEnvironment;

import mutiny.zero.BackpressureStrategy;
import mutiny.zero.TubeConfiguration;
import mutiny.zero.ZeroPublisher;

public class ErrorTubePublisherTckTest extends PublisherVerification<Long> {

    public ErrorTubePublisherTckTest() {
        super(new TestEnvironment());
    }

    @Override
    public Publisher<Long> createPublisher(long elements) {
        TubeConfiguration configuration = new TubeConfiguration().withBackpressureStrategy(BackpressureStrategy.ERROR);
        return ZeroPublisher.create(configuration, tube -> TubeEmitLoop.loop(tube, elements));
    }

    @Override
    public Publisher<Long> createFailedPublisher() {
        return null;
    }
}