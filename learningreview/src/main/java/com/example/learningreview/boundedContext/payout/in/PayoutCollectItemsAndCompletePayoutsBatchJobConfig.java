package com.example.learningreview.boundedContext.payout.in;

import com.example.learningreview.boundedContext.payout.app.PayoutFacade;
import org.springframework.batch.core.job.Job;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.Step;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.infrastructure.repeat.RepeatStatus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PayoutCollectItemsAndCompletePayoutsBatchJobConfig {

    private static final int CHUNK_SIZE = 10;

    private final PayoutFacade payoutFacade;

    public PayoutCollectItemsAndCompletePayoutsBatchJobConfig(PayoutFacade payoutFacade) {
        this.payoutFacade = payoutFacade;
    }
    @Bean
    public Job payoutCollectItemsJobAndCompletePayoutsJob(
            JobRepository jobRepository,
            Step payoutCollectItemsStep)
    {
        return new JobBuilder("payoutCollectItemsJobAndCompletePayoutsJob", jobRepository)
                .start(payoutCollectItemsStep)
                .next(payoutCompletePayouts(jobRepository))
                .build();
    }


    @Bean
    public Step payoutCollectItemsStep(JobRepository jobRepository) {
        return new StepBuilder("payoutCollectItemsStep", jobRepository)
                .tasklet((contribution, chunkContext) -> {
                    int processedCount = payoutFacade.collectPayoutItemsMore(CHUNK_SIZE).getData();
                    if(processedCount == 0){
                        return RepeatStatus.FINISHED;
                        }
                    contribution.incrementWriteCount(processedCount); // 몇 건의 데이터를 처리했는지 Spring Batch 메타데이터에 축적
                    //BATCH_STEP_EXECUTION으로  WRITE_COUNT 컬럼에 기록됨
                    return RepeatStatus.CONTINUABLE;
                })
                .build();
    }

    @Bean
    public Step payoutCompletePayouts(JobRepository jobRepository) {
        return new StepBuilder("payoutCompletePayouts", jobRepository)
                .tasklet((contribution, chunkContext) -> {
                    int processedCount = payoutFacade.completePayoutsMore(CHUNK_SIZE).getData();
                    if(processedCount == 0){
                        return RepeatStatus.FINISHED;
                    }
                    contribution.incrementWriteCount(processedCount); // 몇 건의 데이터를 처리했는지 Spring Batch 메타데이터에 축적
                    //BATCH_STEP_EXECUTION으로  WRITE_COUNT 컬럼에 기록됨
                    return RepeatStatus.CONTINUABLE;
                })
                .build();
    }
}
