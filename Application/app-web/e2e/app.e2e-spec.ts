import { AppWebPage } from './app.po';

describe('app-web App', () => {
  let page: AppWebPage;

  beforeEach(() => {
    page = new AppWebPage();
  });

  it('should display welcome message', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('Welcome to app!!');
  });
});
