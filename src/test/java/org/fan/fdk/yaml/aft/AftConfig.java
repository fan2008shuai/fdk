package org.fan.fdk.yaml.aft;

import java.util.Map;

/**
 * Created by fan.shuai on 2019/11/16.
 */
public class AftConfig {
    private Global global;
    private Map<String, ProviderAftConfig> providers;

    public Global getGlobal() {
        return global;
    }

    public void setGlobal(Global global) {
        this.global = global;
    }

    public Map<String, ProviderAftConfig> getProviders() {
        return providers;
    }

    public void setProviders(Map<String, ProviderAftConfig> providers) {
        this.providers = providers;
    }

    @Override
    public String toString() {
        return "AftConfig{" +
                "global=" + global +
                ", providers=" + providers +
                '}';
    }

    public static class Global {
        private String aftEnable;
        private InnerConfig innerConfig;

        public String getAftEnable() {
            return aftEnable;
        }

        public void setAftEnable(String aftEnable) {
            this.aftEnable = aftEnable;
        }

        public InnerConfig getInnerConfig() {
            return innerConfig;
        }

        public void setInnerConfig(InnerConfig innerConfig) {
            this.innerConfig = innerConfig;
        }

        @Override
        public String toString() {
            return "Global{" +
                    "aftEnable='" + aftEnable + '\'' +
                    ", innerConfig=" + innerConfig +
                    '}';
        }
    }

    public static class ProviderAftConfig {
        private String regulationEffective;
        InnerConfig innerConfig;

        public String getRegulationEffective() {
            return regulationEffective;
        }

        public void setRegulationEffective(String regulationEffective) {
            this.regulationEffective = regulationEffective;
        }

        public InnerConfig getInnerConfig() {
            return innerConfig;
        }

        public void setInnerConfig(InnerConfig innerConfig) {
            this.innerConfig = innerConfig;
        }

        @Override
        public String toString() {
            return "ProviderAftConfig{" +
                    "regulationEffective='" + regulationEffective + '\'' +
                    ", innerConfig=" + innerConfig +
                    '}';
        }
    }

    public static class InnerConfig {
        private int timeWindow;
        private int leastWindowCount;
        private int leastWindowExceptionRateMultiple;
        private double weightDegradeRate;
        private double weightRecoverRate;
        private int degradeLeastWeight;
        private int degradeMaxIpCount;
        private int suspendRecoverThreshold;
        private int suspendRecoverWeight;

        public int getTimeWindow() {
            return timeWindow;
        }

        public void setTimeWindow(int timeWindow) {
            this.timeWindow = timeWindow;
        }

        public int getLeastWindowCount() {
            return leastWindowCount;
        }

        public void setLeastWindowCount(int leastWindowCount) {
            this.leastWindowCount = leastWindowCount;
        }

        public int getLeastWindowExceptionRateMultiple() {
            return leastWindowExceptionRateMultiple;
        }

        public void setLeastWindowExceptionRateMultiple(int leastWindowExceptionRateMultiple) {
            this.leastWindowExceptionRateMultiple = leastWindowExceptionRateMultiple;
        }

        public double getWeightDegradeRate() {
            return weightDegradeRate;
        }

        public void setWeightDegradeRate(double weightDegradeRate) {
            this.weightDegradeRate = weightDegradeRate;
        }

        public double getWeightRecoverRate() {
            return weightRecoverRate;
        }

        public void setWeightRecoverRate(double weightRecoverRate) {
            this.weightRecoverRate = weightRecoverRate;
        }

        public int getDegradeLeastWeight() {
            return degradeLeastWeight;
        }

        public void setDegradeLeastWeight(int degradeLeastWeight) {
            this.degradeLeastWeight = degradeLeastWeight;
        }

        public int getDegradeMaxIpCount() {
            return degradeMaxIpCount;
        }

        public void setDegradeMaxIpCount(int degradeMaxIpCount) {
            this.degradeMaxIpCount = degradeMaxIpCount;
        }

        public int getSuspendRecoverThreshold() {
            return suspendRecoverThreshold;
        }

        public void setSuspendRecoverThreshold(int suspendRecoverThreshold) {
            this.suspendRecoverThreshold = suspendRecoverThreshold;
        }

        public int getSuspendRecoverWeight() {
            return suspendRecoverWeight;
        }

        public void setSuspendRecoverWeight(int suspendRecoverWeight) {
            this.suspendRecoverWeight = suspendRecoverWeight;
        }
    }
}
