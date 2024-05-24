import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewedPostComponent } from './viewed-post.component';

describe('ViewedPostComponent', () => {
  let component: ViewedPostComponent;
  let fixture: ComponentFixture<ViewedPostComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ViewedPostComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(ViewedPostComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
