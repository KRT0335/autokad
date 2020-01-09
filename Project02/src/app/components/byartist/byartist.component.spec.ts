import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ByartistComponent } from './byartist.component';

describe('ByartistComponent', () => {
  let component: ByartistComponent;
  let fixture: ComponentFixture<ByartistComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ByartistComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ByartistComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
