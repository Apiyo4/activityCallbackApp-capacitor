import { Capacitor } from '@capacitor/core';

const usePlatform = () => {
  const platform = Capacitor.getPlatform();
  const isNativeDevice = platform === 'ios' || platform === 'android';
  return {
    isNativeDevice,
    platform,
  }
};

export default usePlatform;
